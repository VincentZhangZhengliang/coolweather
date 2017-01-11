package com.szxkbl.coolweather.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.szxkbl.coolweather.R;
import com.szxkbl.coolweather.db.City;
import com.szxkbl.coolweather.db.Country;
import com.szxkbl.coolweather.db.Province;
import com.szxkbl.coolweather.util.HttpUtil;
import com.szxkbl.coolweather.util.Utility;

import org.litepal.crud.DataSupport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Vincent
 * @time : 2017/1/11 17:43.
 * @Discription :
 */

public class ChooseAreaFragment extends Fragment {
    public static final int LEVEL_PROVINCE = 0;
    public static final int LEVEL_CITY     = 1;
    public static final int LEVEL_COUNTRY  = 2;

    private ProgressDialog       mProgressDialog;
    private TextView             mTitleText;
    private Button               mBackBtn;
    private ListView             mListView;
    private ArrayAdapter<String> mAdapter;
    private List<String> dataList = new ArrayList<>();
    /**
     * 省列表
     */
    private List<Province> mProvinceList;
    /**
     * 市列表
     */
    private List<City>     mCityList;
    /**
     * 县列表
     */
    private List<Country>  mCountryList;

    /**
     * 选中的省份
     */
    private Province mSelectedProvince;
    /**
     * 选中的城市
     */
    private City     mSelectedCity;
    /**
     * 当前选中的级别
     */
    private int      currentLevel;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.choose_area, container, false);
        mTitleText = (TextView) view.findViewById(R.id.title_text);
        mBackBtn = (Button) view.findViewById(R.id.back_button);
        mListView = (ListView) view.findViewById(R.id.list_view);
        mAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, dataList);
        mListView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (currentLevel == LEVEL_PROVINCE) {
                    mSelectedProvince = mProvinceList.get(i);
                } else if (currentLevel == LEVEL_CITY) {
                    mSelectedCity = mCityList.get(i);
                    queryCountries();
                }
            }
        });
        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentLevel == LEVEL_COUNTRY) {
                    queryCities();
                } else if (currentLevel == LEVEL_CITY) {
                    queryProvinces();
                }
            }
        });
        queryProvinces();
    }

    private void queryProvinces() {
        mTitleText.setText("中国");
        mBackBtn.setVisibility(View.GONE);
        mProvinceList = DataSupport.findAll(Province.class);
        if (mProvinceList.size() > 0) {
            dataList.clear();
            for (Province province : mProvinceList) {
                dataList.add(province.getProvincename());
            }
            mAdapter.notifyDataSetChanged();
            mListView.setSelection(0);
            currentLevel = LEVEL_PROVINCE;
        } else {
            String address = "http://guolin.tech/api/china";
            queryFromServer(address, "province");
        }
    }

    private void queryFromServer(String address, final String type) {

        showProgressDialog();
        HttpUtil.sendOkHttpRequest(address, new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        closeProgressDialog();
                        Toast.makeText(getContext(), "加载失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String responseText = response.body().string();
                boolean result = false;
                if ("province".equals(type)) {
                    result = Utility.handProvinceResponse(responseText);
                } else if ("city".equals(type)) {
                    result = Utility.handCityResponse(responseText, mSelectedProvince.getId());
                } else if ("country".equals(type)) {
                    result = Utility.handCountryResponse(responseText, mSelectedCity.getId());
                }
                if (result) {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            closeProgressDialog();
                            if ("province".equals(type)) {
                                queryProvinces();
                            } else if ("city".equals(type)) {
                                queryCities();
                            } else if ("country".equals(type)) {
                                queryCountries();
                            }
                        }
                    });
                }
            }
        });

    }

    private void closeProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    private void showProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog = new ProgressDialog(getActivity());
            mProgressDialog.setMessage("正在加载...");
            mProgressDialog.setCanceledOnTouchOutside(false);
        }
    }

    private void queryCities() {
        mTitleText.setText(mSelectedProvince.getProvincename());
        mBackBtn.setVisibility(View.VISIBLE);
        mCityList = DataSupport.where("province = ?", String.valueOf(mSelectedProvince.getId())).find(City.class);
        if (mCityList.size() > 0) {
            dataList.clear();
            for (City city : mCityList) {
                dataList.add(city.getCityName());
            }
            mAdapter.notifyDataSetChanged();
            mListView.setSelection(0);
            currentLevel = LEVEL_CITY;
        } else {
            int provinceCode = mSelectedProvince.getProvincecode();
            String address = "http://guolin.tech/api.china/" + provinceCode;
            queryFromServer(address, "city");
        }
    }

    private void queryCountries() {
        mTitleText.setText(mSelectedCity.getCityName());
        mBackBtn.setVisibility(View.VISIBLE);
        mCountryList = DataSupport.where("cityid = ?", String.valueOf(mSelectedCity.getId())).find(Country.class);
        if (mCountryList.size() > 0) {
            dataList.clear();
            for (Country country : mCountryList) {
                dataList.add(country.getCountryName());

            }
            mAdapter.notifyDataSetChanged();
            mListView.setSelection(0);
            currentLevel = LEVEL_COUNTRY;
        } else {
            int provinceCode = mSelectedProvince.getProvincecode();
            int cityCode = mSelectedCity.getCityCode();
            String address = "http://guolin.tech/api/china/" + provinceCode + "/" + cityCode;
            queryFromServer(address, "country");
        }
    }
}

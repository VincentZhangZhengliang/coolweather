package com.szxkbl.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * @author : Vincent
 * @time : 2017/1/11 16:52.
 * @Discription :
 */

public class City extends DataSupport {

    private int    id;
    private String cityName;
    private int    cityCode;
    private int    provinceId;

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }
}

package com.szxkbl.coolweather.util;

import android.util.Log;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

/**
 * @author : Vincent
 * @time : 2017/1/11 17:11.
 * @Discription :
 */

public class HttpUtil {
    public static void sendOkHttpRequest(String address, Callback callback) {
        Log.e("TAG", "sendOkHttpRequest: " + address);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}

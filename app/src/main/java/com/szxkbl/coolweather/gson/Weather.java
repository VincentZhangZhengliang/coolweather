package com.szxkbl.coolweather.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/1/15.
 */

public class Weather {
    public String         status;
    public Basic          basic;
    public AQI            aqi;
    public Now            now;
    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;
    public Suggestion     suggestion;
}

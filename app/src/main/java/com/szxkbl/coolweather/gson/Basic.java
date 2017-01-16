package com.szxkbl.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/1/15.
 */

public class Basic {


    /**
     * city : 苏州
     * cnty : 中国
     * id : CN101190401
     * lat : 31.309000
     * lon : 120.612000
     * update : {"loc":"2017-01-15 13:54","utc":"2017-01-15 05:54"}
     */

    @SerializedName("city")
    public String     cityName;
    @SerializedName("cnty")
    public String     cnty;
    @SerializedName("id")
    public String     id;
    @SerializedName("lat")
    public String     lat;
    @SerializedName("lon")
    public String     lon;
    @SerializedName("update")
    public UpdateBean update;

    public static class UpdateBean {
        /**
         * loc : 2017-01-15 13:54
         * utc : 2017-01-15 05:54
         */

        @SerializedName("loc")
        public String updateName;
        @SerializedName("utc")
        public String utc;
    }
}


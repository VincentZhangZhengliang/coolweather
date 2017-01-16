package com.szxkbl.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/1/15.
 */

public class Now {


    /**
     * cond : {"code":"101","txt":"多云"}
     * fl : 3
     * hum : 48
     * pcpn : 0
     * pres : 1032
     * tmp : 6
     * vis : 10
     * wind : {"deg":"36","dir":"东风","sc":"4-5","spd":"20"}
     */

    @SerializedName("cond")
    public More     more;
    @SerializedName("fl")
    public String   fl;
    @SerializedName("hum")
    public String   hum;
    @SerializedName("pcpn")
    public String   pcpn;
    @SerializedName("pres")
    public String   pres;
    @SerializedName("tmp")
    public String   temperature;
    @SerializedName("vis")
    public String   vis;
    @SerializedName("wind")
    public WindBean wind;

    public static class More {
        /**
         * code : 101
         * txt : 多云
         */

        @SerializedName("code")
        public String code;
        @SerializedName("txt")
        public String info;
    }

    public static class WindBean {
        /**
         * deg : 36
         * dir : 东风
         * sc : 4-5
         * spd : 20
         */

        @SerializedName("deg")
        public String deg;
        @SerializedName("dir")
        public String dir;
        @SerializedName("sc")
        public String sc;
        @SerializedName("spd")
        public String spd;
    }
}


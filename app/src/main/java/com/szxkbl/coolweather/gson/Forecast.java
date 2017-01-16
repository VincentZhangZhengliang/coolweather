package com.szxkbl.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/1/15.
 */

public class Forecast {


    /**
     * astro : {"mr":"20:20","ms":"08:48","sr":"06:56","ss":"17:17"}
     * cond : {"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"}
     * date : 2017-01-15
     * hum : 70
     * pcpn : 0.0
     * pop : 0
     * pres : 1031
     * tmp : {"max":"7","min":"1"}
     * uv : 4
     * vis : 10
     * wind : {"deg":"39","dir":"东北风","sc":"3-4","spd":"11"}
     */

    @SerializedName("astro")
    public AstroBean   astro;
    @SerializedName("cond")
    public More        more;
    @SerializedName("date")
    public String      date;
    @SerializedName("hum")
    public String      hum;
    @SerializedName("pcpn")
    public String      pcpn;
    @SerializedName("pop")
    public String      pop;
    @SerializedName("pres")
    public String      pres;
    @SerializedName("tmp")
    public Temperature temperature;
    @SerializedName("uv")
    public String      uv;
    @SerializedName("vis")
    public String      vis;
    @SerializedName("wind")
    public WindBean    wind;

    public static class AstroBean {
        /**
         * mr : 20:20
         * ms : 08:48
         * sr : 06:56
         * ss : 17:17
         */

        @SerializedName("mr")
        public String mr;
        @SerializedName("ms")
        public String ms;
        @SerializedName("sr")
        public String sr;
        @SerializedName("ss")
        public String ss;
    }

    public static class More {
        /**
         * code_d : 101
         * code_n : 101
         * txt_d : 多云
         * txt_n : 多云
         */

        @SerializedName("code_d")
        public String codeD;
        @SerializedName("code_n")
        public String codeN;
        @SerializedName("txt_d")
        public String info;
        @SerializedName("txt_n")
        public String txtN;
    }

    public static class Temperature {
        /**
         * max : 7
         * min : 1
         */

        @SerializedName("max")
        public String max;
        @SerializedName("min")
        public String min;
    }

    public static class WindBean {
        /**
         * deg : 39
         * dir : 东北风
         * sc : 3-4
         * spd : 11
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

package com.szxkbl.coolweather.gson;

/**
 * Created by Administrator on 2017/1/15.
 */

public class AQI {


    /**
     * city : {"aqi":"33","co":"0","no2":"19","o3":"77","pm10":"15","pm25":"12","qlty":"优","so2":"12"}
     */

    public CityBean city;

    public static class CityBean {
        /**
         * aqi : 33
         * co : 0
         * no2 : 19
         * o3 : 77
         * pm10 : 15
         * pm25 : 12
         * qlty : 优
         * so2 : 12
         */

        public String aqi;
        public String co;
        public String no2;
        public String o3;
        public String pm10;
        public String pm25;
        public String qlty;
        public String so2;
    }
}


package com.szxkbl.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/1/15.
 */

public class Suggestion {


    /**
     * air : {"brf":"中","txt":"气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。"}
     * comf : {"brf":"较舒适","txt":"白天天气晴好，早晚会感觉偏凉，午后舒适、宜人。"}
     * cw : {"brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"}
     * drsg : {"brf":"冷","txt":"天气冷，建议着棉服、羽绒服、皮夹克加羊毛衫等冬季服装。年老体弱者宜着厚棉衣、冬大衣或厚羽绒服。"}
     * flu : {"brf":"易发","txt":"昼夜温差很大，易发生感冒，请注意适当增减衣服，加强自我防护避免感冒。"}
     * sport : {"brf":"较不宜","txt":"天气较好，但考虑风力较大，天气寒冷，推荐您进行室内运动，若在户外运动须注意保暖。"}
     * trav : {"brf":"一般","txt":"天空状况还是比较好的，但温度稍微有点低，且风稍大，会让您感觉些许凉意。外出请注意防风。"}
     * uv : {"brf":"最弱","txt":"属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"}
     */

    @SerializedName("air")
    public AirBean air;
    @SerializedName("comf")
    public ComfBean  comf;
    @SerializedName("cw")
    public CwBean    cw;
    @SerializedName("drsg")
    public DrsgBean  drsg;
    @SerializedName("flu")
    public FluBean   flu;
    @SerializedName("sport")
    public SportBean sport;
    @SerializedName("trav")
    public TravBean  trav;
    @SerializedName("uv")
    public UvBean    uv;

    public static class AirBean {
        /**
         * brf : 中
         * txt : 气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。
         */

        @SerializedName("brf")
        public String brf;
        @SerializedName("txt")
        public String txt;
    }

    public static class ComfBean {
        /**
         * brf : 较舒适
         * txt : 白天天气晴好，早晚会感觉偏凉，午后舒适、宜人。
         */

        @SerializedName("brf")
        public String brf;
        @SerializedName("txt")
        public String txt;
    }

    public static class CwBean {
        /**
         * brf : 较适宜
         * txt : 较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。
         */

        @SerializedName("brf")
        public String brf;
        @SerializedName("txt")
        public String txt;
    }

    public static class DrsgBean {
        /**
         * brf : 冷
         * txt : 天气冷，建议着棉服、羽绒服、皮夹克加羊毛衫等冬季服装。年老体弱者宜着厚棉衣、冬大衣或厚羽绒服。
         */

        @SerializedName("brf")
        public String brf;
        @SerializedName("txt")
        public String txt;
    }

    public static class FluBean {
        /**
         * brf : 易发
         * txt : 昼夜温差很大，易发生感冒，请注意适当增减衣服，加强自我防护避免感冒。
         */

        @SerializedName("brf")
        public String brf;
        @SerializedName("txt")
        public String txt;
    }

    public static class SportBean {
        /**
         * brf : 较不宜
         * txt : 天气较好，但考虑风力较大，天气寒冷，推荐您进行室内运动，若在户外运动须注意保暖。
         */

        @SerializedName("brf")
        public String brf;
        @SerializedName("txt")
        public String txt;
    }

    public static class TravBean {
        /**
         * brf : 一般
         * txt : 天空状况还是比较好的，但温度稍微有点低，且风稍大，会让您感觉些许凉意。外出请注意防风。
         */

        @SerializedName("brf")
        public String brf;
        @SerializedName("txt")
        public String txt;
    }

    public static class UvBean {
        /**
         * brf : 最弱
         * txt : 属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。
         */

        @SerializedName("brf")
        public String brf;
        @SerializedName("txt")
        public String txt;
    }
}

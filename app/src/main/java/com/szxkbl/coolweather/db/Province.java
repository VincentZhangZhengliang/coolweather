package com.szxkbl.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * @author : Vincent
 * @time : 2017/1/11 16:52.
 * @Discription :
 */

public class Province extends DataSupport {

    private int id;
    private String  provincename;
    private int provincecode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvincename() {
        return provincename;
    }

    public void setProvincename(String provincename) {
        this.provincename = provincename;
    }

    public int getProvincecode() {
        return provincecode;
    }

    public void setProvincecode(int provincecode) {
        this.provincecode = provincecode;
    }
}

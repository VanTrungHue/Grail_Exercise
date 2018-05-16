package com.example.hue.hienthimonan;

import java.io.Serializable;

public class Recipes implements Serializable{
    private String tenmon;
    private String mota;
    private int anh1;
    private int anh2;

    public Recipes(String tenmon, String mota, int anh1, int anh2) {
        this.tenmon = tenmon;
        this.mota = mota;
        this.anh1 = anh1;
        this.anh2 = anh2;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getAnh1() {
        return anh1;
    }

    public void setAnh1(int anh1) {
        this.anh1 = anh1;
    }

    public int getAnh2() {
        return anh2;
    }

    public void setAnh2(int anh2) {
        this.anh2 = anh2;
    }
}

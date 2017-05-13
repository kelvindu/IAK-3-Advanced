package com.example.yao.iakadvanced.Models;

/**
 * Created by yao on 13/05/17.
 */

public class DataBean {

    private String nama;
    private int umur;

    public DataBean(String nama, int umur){
        this.nama = nama;
        this.umur = umur;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }
}

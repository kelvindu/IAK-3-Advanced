package com.example.yao.iakadvanced.models.main;

import com.example.yao.iakadvanced.utils.URLs;

import java.util.ArrayList;

import okhttp3.Request;

/**
 * Created by yao on 14/05/17.
 */

public class MainModelImp implements MainModel {

    private ArrayList<Data> data;

    public ArrayList<Data> getData(){
        return data;
    }

    public class Data{
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @Override
    public Request build() {
        return new Request.Builder()
                .get()
                .url(URLs.getMainURL())
                .build();
    }
}

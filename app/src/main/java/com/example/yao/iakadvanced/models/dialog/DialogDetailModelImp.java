package com.example.yao.iakadvanced.models.dialog;

import com.example.yao.iakadvanced.models.main.MainModelImp;
import com.example.yao.iakadvanced.utils.URLs;

import java.util.ArrayList;

import okhttp3.Request;

/**
 * Created by yao on 14/05/17.
 */

public class DialogDetailModelImp implements DialogDetailModel {

    private Data data;

    public Data getData(){
        return data;
    }

    public class Data{
        private String name,
            position;

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @Override
    public Request build(String id) {
        return new Request.Builder()
                .get()
                .url(URLs.getDetailUrl(id))
                .build();
    }
}

package com.example.yao.iakadvanced.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by yao on 14/05/17.
 */

public class OkHttpTime {
    public static OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(10000L, TimeUnit.MILLISECONDS)
            .readTimeout(1000L,TimeUnit.MILLISECONDS)
            .build();
}

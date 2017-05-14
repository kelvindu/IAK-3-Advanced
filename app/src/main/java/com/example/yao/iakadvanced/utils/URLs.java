package com.example.yao.iakadvanced.utils;

import com.example.yao.iakadvanced.BuildConfig;

/**
 * Created by yao on 14/05/17.
 */

public class URLs {
    private static final String BASE_URL = BuildConfig.URI;
    private static final String DETAIL_URL = "/detail/";

    public static String getMainURL(){
        return BASE_URL;
    }

    public static String getDetailUrl(String id){
        return BASE_URL+DETAIL_URL+id;
    }

}

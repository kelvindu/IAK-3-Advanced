package com.example.yao.iakadvanced.presenter.main;

import com.example.yao.iakadvanced.models.main.MainModel;
import com.example.yao.iakadvanced.models.main.MainModelImp;
import com.example.yao.iakadvanced.utils.OkHttpTime;
import com.example.yao.iakadvanced.utils.RxOkhttp;
import com.example.yao.iakadvanced.view.main.MainView;
import com.google.gson.Gson;

import okhttp3.Request;
import rx.Observable;

/**
 * Created by yao on 14/05/17.
 */

public class MainPresenterImp implements MainPresenter {
    MainModel model;
    MainView view;

    public MainPresenterImp(MainView view) {
        this.model = new MainModelImp();
        this.view = view;
    }

    @Override
    public Observable<MainModelImp> getResult() {
        Request request = model.build();
        return RxOkhttp.streamStrings(OkHttpTime.client,request).map(json ->
            new Gson().fromJson(json, MainModelImp.class)
        );
    }
}

package com.example.yao.iakadvanced.presenter.dialog;

import com.example.yao.iakadvanced.fragment.DialogDetailView;
import com.example.yao.iakadvanced.models.dialog.DialogDetailModel;
import com.example.yao.iakadvanced.models.dialog.DialogDetailModelImp;
import com.example.yao.iakadvanced.utils.OkHttpTime;
import com.example.yao.iakadvanced.utils.RxOkhttp;
import com.google.gson.Gson;

import okhttp3.Request;
import rx.Observable;

/**
 * Created by yao on 14/05/17.
 */

public class DialogDetailPresenterImp implements DialogDetailPresenter {
    DialogDetailView view;
    DialogDetailModel model;

    public DialogDetailPresenterImp(DialogDetailView view) {
        this.view = view;
        model = new DialogDetailModelImp();
    }

    @Override
    public Observable<DialogDetailModelImp> getResults(String id) {
        Request request = model.build(id);
        return RxOkhttp.streamStrings(OkHttpTime.client, request).map(json ->
                new Gson().fromJson(json, DialogDetailModelImp.class));
    }
}

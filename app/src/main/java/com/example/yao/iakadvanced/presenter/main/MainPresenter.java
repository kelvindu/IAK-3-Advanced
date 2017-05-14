package com.example.yao.iakadvanced.presenter.main;

import com.example.yao.iakadvanced.models.main.MainModelImp;

import rx.Observable;

/**
 * Created by yao on 14/05/17.
 */

public interface MainPresenter {
    Observable<MainModelImp> getResult();
}

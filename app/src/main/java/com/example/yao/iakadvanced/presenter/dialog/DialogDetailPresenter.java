package com.example.yao.iakadvanced.presenter.dialog;

import com.example.yao.iakadvanced.models.dialog.DialogDetailModelImp;

import rx.Observable;

/**
 * Created by yao on 14/05/17.
 */

public interface DialogDetailPresenter {
    Observable<DialogDetailModelImp> getResults(String id);
}

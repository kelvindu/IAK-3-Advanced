package com.example.yao.iakadvanced.view.main;

import com.example.yao.iakadvanced.models.main.MainModelImp;

/**
 * Created by yao on 14/05/17.
 */

public interface MainView {
    void onSuccess(MainModelImp result);
    void onError(Throwable err);
}

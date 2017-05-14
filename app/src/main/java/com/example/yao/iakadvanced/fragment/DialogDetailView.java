package com.example.yao.iakadvanced.fragment;

import com.example.yao.iakadvanced.models.dialog.DialogDetailModelImp;

/**
 * Created by yao on 14/05/17.
 */

public interface DialogDetailView {
    void onSuccess(DialogDetailModelImp result);
    void onError(Throwable err);
}

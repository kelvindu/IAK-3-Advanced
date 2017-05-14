package com.example.yao.iakadvanced.view.main;

import android.os.Bundle;
import android.util.Log;

import com.example.yao.iakadvanced.R;
import com.example.yao.iakadvanced.base.BaseActivity;
import com.example.yao.iakadvanced.presenter.main.MainPresenter;
import com.example.yao.iakadvanced.presenter.main.MainPresenterImp;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity implements MainView {

    private final String TAG = "MainActivity";
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind(R.layout.activity_main);
        mainPresenter = new MainPresenterImp(this);
        subscription = mainPresenter.getResult()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onError);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onSuccess(String result) {
        Log.d(TAG, result);

    }

    @Override
    public void onError(Throwable err) {

    }
}

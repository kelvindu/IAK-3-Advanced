package com.example.yao.iakadvanced.view.splash;

import android.content.Intent;
import android.os.Bundle;

import com.example.yao.iakadvanced.MainActivity;
import com.example.yao.iakadvanced.R;
import com.example.yao.iakadvanced.base.BaseActivity;
import com.example.yao.iakadvanced.presenter.splash.SplashPresenter;
import com.example.yao.iakadvanced.presenter.splash.SplashPresenterImp;

public class SplashActivity extends BaseActivity implements SplashView{
    SplashPresenter splashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_splash);
        splashPresenter = new SplashPresenterImp(this);
        splashPresenter.waitSplash(5000);
    }


    @Override
    public void showAlert() {
        showToast("Hi, welcome");
    }

    @Override
    public void openMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
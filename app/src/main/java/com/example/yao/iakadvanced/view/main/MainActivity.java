package com.example.yao.iakadvanced.view.main;

import android.os.Bundle;

import com.example.yao.iakadvanced.R;
import com.example.yao.iakadvanced.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind(R.layout.activity_main);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

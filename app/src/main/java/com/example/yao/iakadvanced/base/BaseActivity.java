package com.example.yao.iakadvanced.base;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.yao.iakadvanced.R;

import butterknife.ButterKnife;

/**
 * Created by yao on 13/05/17.
 */

public class BaseActivity extends AppCompatActivity {
    protected void bind(int layout){
        setContentView(layout);
        ButterKnife.bind(this);
    }

    protected void showToast(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    protected void openNewActivity(){
    }
}

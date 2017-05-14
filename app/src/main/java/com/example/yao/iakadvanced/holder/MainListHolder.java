package com.example.yao.iakadvanced.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.yao.iakadvanced.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yao on 14/05/17.
 */

public class MainListHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.list_id)
    TextView tv_id;
    @BindView(R.id.list_name)
    TextView tv_name;

    public MainListHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void bind(int id, String name){
        tv_id.setText(id);
        tv_name.setText(name);
    }
}

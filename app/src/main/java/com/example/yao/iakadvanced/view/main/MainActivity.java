package com.example.yao.iakadvanced.view.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.yao.iakadvanced.R;
import com.example.yao.iakadvanced.adapter.ListAdapter;
import com.example.yao.iakadvanced.base.BaseActivity;
import com.example.yao.iakadvanced.fragment.DialogDetail;
import com.example.yao.iakadvanced.holder.MainListHolder;
import com.example.yao.iakadvanced.models.main.MainModelImp;
import com.example.yao.iakadvanced.presenter.main.MainPresenter;
import com.example.yao.iakadvanced.presenter.main.MainPresenterImp;

import butterknife.BindView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity implements MainView {

    private final String TAG = "MainActivity";
    private MainPresenter mainPresenter;

    @BindView(R.id.rv_list)
    RecyclerView recyclerView;
    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
    public void onSuccess(MainModelImp result) {
        Log.d(TAG, result.getData().get(0).getName());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ListAdapter<MainModelImp.Data, MainListHolder>(
                R.layout.simple_list,
                MainListHolder.class,
                MainModelImp.Data.class,
                result.getData()) {

            @Override protected void bindView(MainListHolder holder,
                                              MainModelImp.Data model,
                                              final int i) {
                holder.bind(model.getId(),model.getName());
                holder.getItemLayout().setOnClickListener(v -> {
                    DialogDetail detail = new DialogDetail();
                    Bundle bundle = new Bundle();
                    bundle.putString("id",String.valueOf(model.getId()));
                    detail.setArguments(bundle);
                    detail.show(getFragmentManager(), "Detail");
                });
            }
        };

        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onError(Throwable err) {

    }
}

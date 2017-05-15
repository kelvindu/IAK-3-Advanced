package com.example.yao.iakadvanced.fragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yao.iakadvanced.R;
import com.example.yao.iakadvanced.models.dialog.DialogDetailModelImp;
import com.example.yao.iakadvanced.presenter.dialog.DialogDetailPresenterImp;


import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by yao on 14/05/17.
 */

public class DialogDetail extends DialogFragment implements DialogDetailView{

    public static final String TAG = "DialogDetail";
    @BindView(R.id.dialog_name)
    TextView tvDialogName;
    @BindView(R.id.dialog_position)
    TextView tvDialogPosition;

    Subscription subscription = new CompositeSubscription();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_detail,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);

        String id = getArguments().getString("id");
        Log.d(TAG, id);
        subscription = new DialogDetailPresenterImp(this)
                .getResults(id)
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onError);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        subscription.unsubscribe();
    }

    @Override
    public void onSuccess(DialogDetailModelImp result) {
        Log.d(TAG, result.getData().getName());
        Log.d(TAG, result.getData().getPosition());
        tvDialogName.setText(result.getData().getName());
        tvDialogPosition.setText(result.getData().getPosition());
    }

    @Override
    public void onError(Throwable err) {
        Log.e(TAG, err.getMessage());
    }
}

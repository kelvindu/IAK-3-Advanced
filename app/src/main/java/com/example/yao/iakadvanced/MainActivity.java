package com.example.yao.iakadvanced;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_test_1)
    TextView tvTest1;
    @BindView(R.id.tv_test_2)
    TextView tvTest2;

    private Subscription subscription = new CompositeSubscription();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        procData();
    }

    public void procData(){
        Observable<Integer> datas = Observable.just(1,2,3,4,5,6,7,8,9,10);

        datas.map(data -> {
            StringBuilder stringBuilder = new StringBuilder();
            if(data%2 == 1){
                stringBuilder.append(data.toString());
            }
            return stringBuilder;
        });

        subscription = datas
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSucceed, this::onError);
    }

    private void onSucceed(Integer i){
        tvTest1.setText(i);
    }

    private void onError(Throwable err){}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        subscription.unsubscribe();
    }
}

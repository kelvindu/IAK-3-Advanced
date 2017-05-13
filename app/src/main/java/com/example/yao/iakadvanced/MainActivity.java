package com.example.yao.iakadvanced;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.yao.iakadvanced.Models.DataBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_test_1)
    TextView tvTest1;

    private Subscription subscription = new CompositeSubscription();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        procObject();
    }

    public void procObject(){
        DataBean identitas = new DataBean("Jono",22);
        Observable<DataBean> myData = Observable.just(identitas);

        subscription = myData
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<DataBean>() {
                    @Override
                    public void call(DataBean dataBean) {
                        tvTest1.setText(dataBean.getNama()+"\n"+dataBean.getUmur());
                    }
                });

    }

    public void procData(){
        int[] datas = {1,2,3,4,5,6,7,8,9,10};
        Observable<int[]> myData = Observable.just(datas);

        subscription = myData.map(angkas -> {
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0;i<angkas.length; i++){
                if(angkas[i] % 2 == 1){
                    stringBuilder.append(angkas[i]+"\n");
                }
            }
            return stringBuilder;
        }).observeOn(Schedulers.io())
          .subscribeOn(AndroidSchedulers.mainThread())
          .subscribe(this::onSucceed,this::onError);

    }

    private void onSucceed(StringBuilder stringBuilder) {
        tvTest1.setText(stringBuilder);
    }

    private void onError(Throwable err){}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        subscription.unsubscribe();
    }
}

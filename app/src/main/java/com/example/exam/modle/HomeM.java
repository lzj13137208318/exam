package com.example.exam.modle;

import com.example.exam.bean.ShouYeBean;
import com.example.exam.https.Home;
import com.example.exam.https.ResultCallback;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeM {

    public void getData(final ResultCallback callback) {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(Home.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Home home = build.create(Home.class);
        home.getHomeBean()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ShouYeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShouYeBean shouYeBean) {
                        callback.ok(shouYeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.no(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

package com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.mvp;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by baocheng.liu on 2017/12/19.
 */

public class BaseInteractor {

    private static final String mBaseUrl = "http://liaoning.dev.eascs.com/easd/";

    protected Retrofit mRetrofit;

    private final String TAG = "BaseInteractor";

    public BaseInteractor() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public BaseInteractor(String baseUrl) {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}

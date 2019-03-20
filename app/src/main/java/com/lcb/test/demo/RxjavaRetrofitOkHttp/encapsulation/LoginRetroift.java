package com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation;

import com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.entity.outEntity.LoginOutEntity;
import com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.service.LoginService;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class LoginRetroift {

    public static final String BASE_URL = "http://liaoning.dev.eascs.com/easd/";

    private static LoginRetroift sInstance;

    public static LoginRetroift getInstance() {
        if (sInstance == null) {
            synchronized (LoginRetroift.class) {
                if (sInstance == null) {
                    sInstance = new LoginRetroift();
                }
            }
        }
        return sInstance;
    }


    public Observable<LoginOutEntity> init(Map<String, String> map) {
        LoginService loginService = initRetroift().create(LoginService.class);
        return loginService.getLogin(map);
    }

    private Retrofit initRetroift() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(initOkHttp())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }

    private OkHttpClient initOkHttp() {
        OkHttpClient myOkHttp = new OkHttpClient.Builder()
                .connectTimeout(5 * 60 * 1000, TimeUnit.SECONDS)
                .readTimeout(5 * 60 * 1000, TimeUnit.SECONDS)
                .writeTimeout(5 * 60 * 1000, TimeUnit.SECONDS)
                .build();
        return myOkHttp;
    }
}

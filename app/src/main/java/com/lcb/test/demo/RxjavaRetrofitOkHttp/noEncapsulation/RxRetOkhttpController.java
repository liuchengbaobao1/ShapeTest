package com.lcb.test.demo.RxjavaRetrofitOkHttp.noEncapsulation;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.entity.outEntity.LoginOutEntity;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by baocheng.liu on 2017/12/14.
 */

public class RxRetOkhttpController {

    public static void getLogin(final Context mContext) {
        String BASE_URL = "http://liaoning.dev.eascs.com/easd/";

        //日志显示级别
        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
        //新建log拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("lcb", "OkHttp====Message:" + message);
            }
        });
        loggingInterceptor.setLevel(level);

        okhttp3.OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(5, TimeUnit.SECONDS);
        builder.addInterceptor(loggingInterceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        HttpPostService apiService = retrofit.create(HttpPostService.class);

        String data = "{\"username\":\"cs.ansmsmahaibin\",\"password\":\"123456\",\"udid\":\"863049035586679\"}";
        HashMap<String, String> map = new HashMap<>();
        map.put("data", data);
        Observable<LoginOutEntity> observable = apiService.getLogin(map);

        observable.subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Subscriber<LoginOutEntity>() {
                            @Override
                            public void onCompleted() {
                                Toast.makeText(mContext, "onCompleted", Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onError(Throwable e) {
                                Toast.makeText(mContext, "onError", Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onNext(LoginOutEntity retrofitEntity) {
                                Toast.makeText(mContext, retrofitEntity.toString(), Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onStart() {
                                Toast.makeText(mContext, "onStart", Toast.LENGTH_LONG).show();
                            }
                        }

                );
    }
}

package com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.interactor;

import com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.LoginRetroift;
import com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.entity.inEntity.LoginInEntity;
import com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.entity.outEntity.LoginOutEntity;
import com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.mvp.BaseInteractor;
import com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.net.ResponseListener;
import com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.service.LoginService;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by baocheng.liu on 2017/12/19.
 */

public class LoginInteractor extends BaseInteractor{

    private LoginService mLoginService;

    public LoginInteractor(){
        mLoginService = mRetrofit.create(LoginService.class);
    }

    public void reqLogin(LoginInEntity in, final ResponseListener<LoginOutEntity> listener) {
        Observable<LoginOutEntity> observable = mLoginService.getLogin(in.getParams());
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<LoginOutEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onErrorResponse(e);
                    }

                    @Override
                    public void onNext(LoginOutEntity loginOutEntity) {
                        listener.onResponse(loginOutEntity);
                    }
                });
    }
}

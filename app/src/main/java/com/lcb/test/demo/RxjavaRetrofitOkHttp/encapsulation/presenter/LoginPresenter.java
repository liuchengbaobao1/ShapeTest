package com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.presenter;

import com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.contract.LoginContract;
import com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.entity.inEntity.LoginInEntity;
import com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.entity.outEntity.LoginOutEntity;
import com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.interactor.LoginInteractor;
import com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.net.ResponseListener;

public class LoginPresenter implements LoginContract.Presenter {

    LoginContract.IView mView;

    public LoginPresenter(LoginContract.IView view) {
        mView = view;
    }

    @Override
    public void reqLogin(final String userName, final String passWord) {
        LoginInEntity in = new LoginInEntity(userName, passWord);
        if(!in.checkInput()){
            mView.onError(in.getErrors().get(0));
            return;
        }
        mView.showLoding(" 正在登录，请稍后...");
        new LoginInteractor().reqLogin(in, new ResponseListener<LoginOutEntity>() {
            @Override
            public void onResponse(LoginOutEntity response) {
                mView.dismissLoding();
                if (response == null) {
                    mView.onError("网络或服务器异常");
                } else {
                    if (Code._200.equals(response.code)) {
                        mView.onRespLogin(response.toString());
                    } else {
                        mView.onError(response.message);
                    }
                }
            }

            @Override
            public void onErrorResponse(Throwable error) {
                mView.dismissLoding();
                mView.onError(error.getMessage());
            }
        });
    }
}

package com.lcb.test.formal.mvp.presenter;

import com.lcb.test.formal.mvp.contract.LoginContract;

/**
 * Created by baocheng.liu on 2017/5/15.
 */

public class LoginPresenter implements LoginContract.Presenter {

    LoginContract.IView mView;

    public LoginPresenter(LoginContract.IView view) {
        mView = view;
    }

    @Override
    public void reqLogin(final String userName, final String passWord) {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if ("1311333388".equals(userName) && "123456".equals(passWord)) {
            mView.onRespLogin("登录成功");
        } else {
            mView.onError("用户名密码错误!");
        }
    }
}

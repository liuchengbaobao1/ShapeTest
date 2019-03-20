package com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.entity.inEntity;

import android.text.TextUtils;

/**
 * Created by baocheng.liu on 2017/12/14.
 */

public class LoginInEntity extends InputEntity{

    private String username;
    private String password;
    private String udid;

    public LoginInEntity(String username, String password) {
        this.udid = "863049035586679";
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean checkInput() {
        if (TextUtils.isEmpty(username)) {
            errors.add("请输入账号");
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            errors.add("请输入密码");
            return false;
        }
        return super.checkInput();
    }
}

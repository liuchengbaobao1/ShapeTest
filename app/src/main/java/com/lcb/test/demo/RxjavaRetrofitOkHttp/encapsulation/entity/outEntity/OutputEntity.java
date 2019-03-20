package com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.entity.outEntity;

import android.text.TextUtils;

import java.io.Serializable;

/**
 * Created by baocheng.liu on 2017/12/20.
 */

public class OutputEntity implements Serializable{

    public String code;
    public String message;
    public String state;

    public String getErrorMsg(){
        return TextUtils.isEmpty(message) ? "网络或服务器异常": message;
    }
}

package com.lcb.test.demo.fragmentinactivity.base;

/**
 * Created by baocheng.liu on 2017/12/7.
 */

public interface BaseView {

    void showLoding(String msg);

    void dismissLoding(String msg);

    void onError(String msg);
}

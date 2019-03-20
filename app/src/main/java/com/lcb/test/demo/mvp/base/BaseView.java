package com.lcb.test.demo.mvp.base;

/**
 * Created by baocheng.liu on 2017/5/15.
 */

public interface BaseView {

    void showLoding(String msg);

    void dismissLoding(String msg);

    void onError(String msg);
}

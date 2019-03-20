package com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.mvp;

/**
 * Created by baocheng.liu on 2017/12/19.
 */

public interface BaseView {

    void showLoding(String msg);

    void dismissLoding();

    void onError(String msg);
}

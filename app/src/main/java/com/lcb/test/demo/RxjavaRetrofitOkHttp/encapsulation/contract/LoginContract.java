package com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.contract;

import com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.mvp.BasePresenter;
import com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.mvp.BaseView;

/**
 * Created by baocheng.liu on 2017/12/11.
 */

public interface LoginContract {

    interface IView extends BaseView {
        void onRespLogin(String msg);
    }


    interface Presenter extends BasePresenter{
        void reqLogin(String userName, String passWord);
    }
}

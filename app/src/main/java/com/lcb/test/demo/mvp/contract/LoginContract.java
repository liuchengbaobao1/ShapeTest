package com.lcb.test.demo.mvp.contract;

import com.lcb.test.demo.mvp.base.BaseView;

/**
 * Created by baocheng.liu on 2017/5/15.
 */

public interface LoginContract {

    interface IView extends BaseView {
        void onRespLogin(String msg);
    }


    interface Presenter {
        void reqLogin(String userName, String passWord);
    }

}

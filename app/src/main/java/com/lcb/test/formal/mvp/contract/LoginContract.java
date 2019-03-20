package com.lcb.test.formal.mvp.contract;

import com.lcb.test.formal.mvp.base.BaseView;

/**
 * Created by baocheng.liu on 2017/5/15.
 */

public class LoginContract {

    public interface IView extends BaseView {
        void onRespLogin(String msg);
    }

    public interface Presenter {
        void reqLogin(String userName, String passWord);
    }

}

package com.lcb.test.demo.fragmentinactivity.contract;

import com.lcb.test.demo.fragmentinactivity.base.BaseView;
import com.lcb.test.demo.fragmentinactivity.entity.UserEntity;

import java.util.ArrayList;

/**
 * Created by baocheng.liu on 2017/12/7.
 */

public interface UserContract {

    interface IView extends BaseView {
        void onRespList(ArrayList<UserEntity> userList);
    }

    interface Presenter {
        void reqUserList();
    }
}

package com.lcb.test.demo.fragmentinactivity.presenter;

import com.lcb.test.demo.fragmentinactivity.contract.UserContract;
import com.lcb.test.demo.fragmentinactivity.entity.UserEntity;

import java.util.ArrayList;

/**
 * Created by baocheng.liu on 2017/12/7.
 */

public class UserPresenter implements UserContract.Presenter {

    UserContract.IView mIView;

    public UserPresenter(UserContract.IView view){
        this.mIView = view;
    }

    @Override
    public void reqUserList() {
        ArrayList<UserEntity> userList = new ArrayList<>();
        UserEntity user1 = new UserEntity("张三","1");
        UserEntity user2 = new UserEntity("李四","2");
        UserEntity user3 = new UserEntity("王五","3");
        UserEntity user4 = new UserEntity("赵六","4");
        UserEntity user5 = new UserEntity("刘七","5");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        mIView.onRespList(userList);
    }
}

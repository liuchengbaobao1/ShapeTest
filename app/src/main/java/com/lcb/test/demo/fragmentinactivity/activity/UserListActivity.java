package com.lcb.test.demo.fragmentinactivity.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.lcb.test.R;
import com.lcb.test.demo.fragmentinactivity.entity.UserEntity;
import com.lcb.test.demo.fragmentinactivity.fragment.UserListFragment;
import com.lcb.test.formal.base.BaseActivity;

public class UserListActivity extends BaseActivity implements UserListFragment.UserListListener {

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, UserListActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new UserListFragment());
        }
    }

    @Override
    public void onUserClicked(UserEntity userEntity) {
        mNavigator.navigatorToUserDetial(this, userEntity.usernName);
    }
}

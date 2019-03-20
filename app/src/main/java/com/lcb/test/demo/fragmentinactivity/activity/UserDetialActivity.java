package com.lcb.test.demo.fragmentinactivity.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.lcb.test.R;
import com.lcb.test.demo.fragmentinactivity.fragment.UserDetialFragment;
import com.lcb.test.formal.base.BaseActivity;

public class UserDetialActivity extends BaseActivity {

    private static final String EXTRAS_USERNAME = "username";

    private String userName;

    public static Intent getCallingIntent(Context context, String userName) {
        Intent intent = new Intent(context, UserDetialActivity.class);
        intent.putExtra(EXTRAS_USERNAME, userName);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detial);
        initializeActivity(savedInstanceState);
    }

    private void initializeActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            userName = getIntent().getStringExtra(EXTRAS_USERNAME);
            addFragment(R.id.fragmentContainer,UserDetialFragment.forUser(userName));
        }else{
            userName = savedInstanceState.getString(EXTRAS_USERNAME);
        }
    }
}

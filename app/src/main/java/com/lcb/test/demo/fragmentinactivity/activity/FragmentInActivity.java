package com.lcb.test.demo.fragmentinactivity.activity;

import android.os.Bundle;
import android.view.View;

import com.lcb.test.R;
import com.lcb.test.formal.base.BaseActivity;

public class FragmentInActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_in);
    }

    public void comein(View view){
        mNavigator.navigatorToUserList(this);
    }
}

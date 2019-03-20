package com.lcb.test.demo.fragmentinactivity.navigation;

import android.content.Context;
import android.content.Intent;

import com.lcb.test.demo.fragmentinactivity.activity.UserDetialActivity;
import com.lcb.test.demo.fragmentinactivity.activity.UserListActivity;

/**
 * Created by baocheng.liu on 2017/12/7.
 */

public class Navigator {
    public Navigator() {
    }

    public void navigatorToUserList(Context context) {
        if (context != null) {
            Intent intent = UserListActivity.getCallingIntent(context);
            context.startActivity(intent);
        }
    }

    public void navigatorToUserDetial(Context context, String userId) {
        if (context != null) {
            Intent intent = UserDetialActivity.getCallingIntent(context, userId);
            context.startActivity(intent);
        }
    }
}

package com.lcb.test.formal.base;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by baocheng.liu on 2017/3/20.
 */

public class BaseApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        LeakCanary.install(this);
    }

    public static Context getContext() {
        return mContext;
    }
}

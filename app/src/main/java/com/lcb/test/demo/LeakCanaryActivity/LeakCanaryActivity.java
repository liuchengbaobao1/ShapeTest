package com.lcb.test.demo.LeakCanaryActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lcb.test.formal.base.BaseActivity;
import com.lcb.test.formal.base.BaseApplication;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by chengbao.liu on 2018/11/22.
 */

public class LeakCanaryActivity extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LeakThread leakThread = new LeakThread();
        leakThread.start();
    }


    class LeakThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(6 * 60 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}

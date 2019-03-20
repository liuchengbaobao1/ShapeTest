package com.lcb.test.demo.customtoolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import com.lcb.test.R;
import com.lcb.test.formal.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

public class CustomToolBarActivity extends BaseActivity {


    private boolean isExit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTranslucentStatus(Color.TRANSPARENT);
        setContentView(R.layout.activity_custom_tool_bar);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        extiAppWithToast();
        return true;
    }

    @Override
    public void onBackPressed() {
        extiAppWithToast();
    }

    private void extiAppWithToast() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(this, "在按一次退出程序", Toast.LENGTH_LONG).show();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false;
                }
            }, 2000);
        } else {
            finish();
        }
    }
}

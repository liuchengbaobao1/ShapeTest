package com.lcb.test.formal.view.mysnackbar;


import android.view.View;
import android.view.ViewGroup;

import com.lcb.test.R;
import com.lcb.test.formal.callback.SimpleCallback;

/**
 * Created by baocheng.liu on 2017/3/21.
 */

public class MySnackBar {

    private TSnackbar snackBar;
    private int APP_DOWN = TSnackbar.APPEAR_FROM_TOP_TO_DOWN;

    private static MySnackBar sInstance;

    public static MySnackBar getInstance() {
        if (sInstance == null) {
            synchronized (MySnackBar.class) {
                if (sInstance == null) {
                    sInstance = new MySnackBar();
                }
            }
        }
        return sInstance;
    }

    public MySnackBar() {
    }

    /**
     * 成功
     */
    public void Success(ViewGroup viewGroup, String msg) {
        snackBar = TSnackbar.make(viewGroup, msg, TSnackbar.LENGTH_SHORT, APP_DOWN);
        snackBar.setPromptThemBackground(Prompt.SUCCESS);
        snackBar.show();
    }

    /**
     * 错误
     */
    public void Error(ViewGroup viewGroup, String msg) {
        snackBar = TSnackbar.make(viewGroup, msg, TSnackbar.LENGTH_LONG, APP_DOWN);
        snackBar.addIcon(R.mipmap.ic_launcher, 100, 100);
        snackBar.setPromptThemBackground(Prompt.ERROR);
        snackBar.show();
    }

    /**
     * 警告
     */
    public void Warning(ViewGroup viewGroup, String msg) {
        snackBar = TSnackbar.make(viewGroup, msg, TSnackbar.LENGTH_LONG, APP_DOWN);
        snackBar.addIcon(R.mipmap.ic_launcher, 100, 100);
        snackBar.setPromptThemBackground(Prompt.WARNING);
        snackBar.show();
    }

    /**
     * 正在加载。。。
     */
    public void Loading(ViewGroup viewGroup, String msg) {
        snackBar = TSnackbar.make(viewGroup, msg, TSnackbar.LENGTH_INDEFINITE, APP_DOWN);
        snackBar.setPromptThemBackground(Prompt.SUCCESS);
        snackBar.addIconProgressLoading(0, true, false);
        snackBar.show();
    }

    /**
     * 正在加载。。。有按钮
     */
    public void LoadingBtn(ViewGroup viewGroup, String msg, String btnText, final SimpleCallback callback) {
        snackBar = TSnackbar.make(viewGroup, msg, TSnackbar.LENGTH_INDEFINITE, APP_DOWN);
        snackBar.setAction(btnText, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onCallback(null);
            }
        });
        snackBar.setPromptThemBackground(Prompt.SUCCESS);
        snackBar.addIconProgressLoading(0, true, false);
        snackBar.show();
    }

    /**
     * 加载成功
     */
    public void LoadSuccess(String msg) {
        if (snackBar != null) {
            snackBar.setPromptThemBackground(Prompt.SUCCESS).setText(msg).setDuration(TSnackbar.LENGTH_LONG).show();
        }
    }

    /**
     * 加载失败
     */
    public void LoadFail(String msg) {
        if (snackBar != null) {
            snackBar.setPromptThemBackground(Prompt.ERROR).setText(msg).setDuration(TSnackbar.LENGTH_LONG).show();
        }
    }
}

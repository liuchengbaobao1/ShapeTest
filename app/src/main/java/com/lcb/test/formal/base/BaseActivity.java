package com.lcb.test.formal.base;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.lcb.test.demo.fragmentinactivity.navigation.Navigator;
import com.lcb.test.formal.callback.SimpleCallback;
import com.lcb.test.formal.dao.ConfigDao;
import com.lcb.test.formal.view.mysnackbar.MySnackBar;

/**
 * Created by baocheng.liu on 2017/3/20.
 */

public class BaseActivity extends AppCompatActivity {

    public ConfigDao mConfigDao;
    public MySnackBar mSnackBar;
    private ViewGroup mViewGroup;
    private ViewGroup mRootView;
    public Navigator mNavigator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewGroup = (ViewGroup) findViewById(android.R.id.content);
        mRootView = (ViewGroup) mViewGroup.getRootView();
        mConfigDao = ConfigDao.getInstance();
        mSnackBar = MySnackBar.getInstance();
        mNavigator = new Navigator();
    }

    public void initTranslucentStatus(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏颜色
            window.setStatusBarColor(color);
            View childAt = mViewGroup.getChildAt(0);
            if (childAt != null) {
                childAt.setFitsSystemWindows(true);
            }
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

        }
    }

    protected void addFragment(int containerViewId, Fragment fragment) {
        final FragmentTransaction mFragmentTrasaction = getFragmentManager().beginTransaction();
        mFragmentTrasaction.add(containerViewId, fragment);
        mFragmentTrasaction.commitAllowingStateLoss();
    }

    /**
     * 错误
     */
    public void Error(String error) {
        mSnackBar.Error(mRootView, error);
    }

    /**
     * 成功
     */
    public void Success(String success) {
        mSnackBar.Success(mRootView, success);
    }

    /**
     * 警告
     */
    public void Warn(String warn) {
        mSnackBar.Warning(mRootView, warn);
    }

    /**
     * 正在加载。。。
     */
    public void Loading(String msg) {
        mSnackBar.Loading(mRootView, msg);
    }

    /**
     * 正在加载。。。带按钮
     */
    public void LoadingBtn(String msg, String btnText, SimpleCallback callback) {
        mSnackBar.LoadingBtn(mRootView, msg, btnText, callback);
    }

    /**
     * 加载成功
     */
    public void LoadSuccess(String msg) {
        mSnackBar.LoadSuccess(msg);
    }

    /**
     * 加载失败
     */
    public void LoadFail(String msg) {
        mSnackBar.LoadFail(msg);
    }
}

package com.lcb.test.demo.mvp.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.lcb.test.R;
import com.lcb.test.demo.mvp.contract.LoginContract;
import com.lcb.test.demo.mvp.presenter.LoginPresenter;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MvpLoginActivity extends AppCompatActivity implements LoginContract.IView {

    LoginPresenter presenter;

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_login);
        ButterKnife.bind(this);
        mContext = MvpLoginActivity.this;
        presenter = new LoginPresenter(MvpLoginActivity.this);
    }

    @OnClick(R.id.mvp_login)
    public void onClick() {
        showLoding("正在登录。。。");
        presenter.reqLogin("15140545080", "123456");
    }

    @Override
    public void onRespLogin(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoding(String msg) {
    }

    @Override
    public void dismissLoding(String msg) {

    }

    @Override
    public void onError(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }
}

package com.lcb.test.demo.RxjavaRetrofitOkHttp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lcb.test.R;
import com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.contract.LoginContract;
import com.lcb.test.demo.RxjavaRetrofitOkHttp.encapsulation.presenter.LoginPresenter;
import com.lcb.test.demo.RxjavaRetrofitOkHttp.noEncapsulation.RxRetOkhttpController;
import com.lcb.test.formal.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by baocheng.liu on 2017/10/17.
 */

public class RxJavaLoginTestActivity extends BaseActivity implements LoginContract.IView {

    @BindView(R.id.btn_text)
    Button mBtn;
    @BindView(R.id.btn_text1)
    Button mBtn1;

    LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        ButterKnife.bind(this);
        mLoginPresenter = new LoginPresenter(this);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RxRetOkhttpController.getLogin(RxJavaLoginTestActivity.this);
            }
        });
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLoginPresenter.reqLogin("cs.ansmsmahaibin", "123456");
            }
        });
    }

    @Override
    public void showLoding(String msg) {
        Toast.makeText(RxJavaLoginTestActivity.this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void dismissLoding() {
        Toast.makeText(RxJavaLoginTestActivity.this, "加载完毕", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(RxJavaLoginTestActivity.this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRespLogin(String msg) {
        Toast.makeText(RxJavaLoginTestActivity.this, msg, Toast.LENGTH_LONG).show();
    }
}

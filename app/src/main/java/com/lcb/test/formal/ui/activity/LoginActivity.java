package com.lcb.test.formal.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;

import com.lcb.test.R;
import com.lcb.test.demo.OldMainActivity;
import com.lcb.test.formal.base.BaseActivity;
import com.lcb.test.formal.callback.SimpleCallback;
import com.lcb.test.formal.mvp.activity.MvpLoginActivity;
import com.lcb.test.formal.utils.SoftInputUtil;
import com.lcb.test.formal.utils.Utils;
import com.lcb.test.formal.view.immersive.Immersive;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.logo)
    ImageView logo;
    @BindView(R.id.username)
    TextInputLayout username;
    @BindView(R.id.password)
    TextInputLayout password;
    @BindView(R.id.isshowpassword)
    CheckBox cbShowPassWord;
    @BindView(R.id.isremembpassword)
    CheckBox cbRemembPassWord;
    EditText edUserName, edPassWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Immersive.setContentView(this, R.layout.activity_login, R.color.blue_title, R.color.blue_title, false, false);
//        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        initTranslucentStatus(Color.TRANSPARENT);

        edUserName = username.getEditText();
        edPassWord = password.getEditText();

        if (!TextUtils.isEmpty(mConfigDao.getUserName())) {
            edUserName.setText(mConfigDao.getUserName());
        }
        if (!TextUtils.isEmpty(mConfigDao.getPassWord())) {
            edPassWord.setText(mConfigDao.getPassWord());
        }
        if (mConfigDao.isShowPassWord()) {
            edPassWord.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            edPassWord.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        cbShowPassWord.setChecked(mConfigDao.isShowPassWord());
        cbRemembPassWord.setChecked(mConfigDao.isRemembPassWord());


        edUserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() < 12) {
                    if (s.length() == 11) {
                        if (Utils.judgePhoneNums(edUserName.getText().toString())) {
                            username.setErrorEnabled(false);
                        } else {
                            username.setErrorEnabled(true);
                            username.setError("手机号格式错误");
                        }
                    } else {
                        username.setErrorEnabled(false);
                    }
                } else {
                    username.setErrorEnabled(true);
                    username.setError("手机号长度不能超过11位");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edPassWord.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 6) {
                    password.setErrorEnabled(true);
                    password.setError("密码长度不能超过6位");
                } else {
                    password.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        cbShowPassWord.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    //显示密码
                    edPassWord.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    mConfigDao.setShowPassWord(isChecked);
                } else {
                    //隐藏密码
                    edPassWord.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    mConfigDao.setShowPassWord(isChecked);
                }
            }
        });

        cbRemembPassWord.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    mConfigDao.setRemembPassWord(isChecked);
                } else {
                    mConfigDao.setRemembPassWord(isChecked);
                }
            }
        });

        logo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                startActivity(new Intent(LoginActivity.this, MvpLoginActivity.class));
                return false;
            }
        });
    }

    public void loginOnClick(View view) {
        Immersive.setNavigationBarColorRes(this, R.color.colorPrimary);
        Immersive.setStatusBarColorRes(this, R.color.colorPrimary);

        String tUserName = edUserName.getText().toString();
        String tPassWord = edPassWord.getText().toString();

        if (TextUtils.isEmpty(tUserName) || TextUtils.isEmpty(tPassWord)) {
            Warn("用户名和密码不能为空！");
            return;
        }
        if (!Utils.judgePhoneNums(tUserName)) {
            Error("手机号格式错误");
            return;
        }
        if (tPassWord.length() != 6) {
            Error("密码长度必须6位");
            return;
        }
        Loading("正在登陆，请稍后...");
        if (mConfigDao.isRemembPassWord()) {
            mConfigDao.setUserName(tUserName);
            mConfigDao.setPassWord(tPassWord);
        } else {
            mConfigDao.setUserName("");
            mConfigDao.setPassWord("");
        }
        mHandler.sendEmptyMessageDelayed(1, 5000);
    }

    public void loginTestOnClick(View view) {
        String tUserName = edUserName.getText().toString();
        String tPassWord = edPassWord.getText().toString();

        if (TextUtils.isEmpty(tUserName) || TextUtils.isEmpty(tPassWord)) {
            Warn("用户名和密码不能为空！");
            return;
        }
        if (!Utils.judgePhoneNums(tUserName)) {
            Error("手机号格式错误");
            return;
        }
        if (tPassWord.length() != 6) {
            Error("密码长度必须6位");
            return;
        }
        if (mConfigDao.isRemembPassWord()) {
            mConfigDao.setUserName(tUserName);
            mConfigDao.setPassWord(tPassWord);
        } else {
            mConfigDao.setUserName("");
            mConfigDao.setPassWord("");
        }

        LoadingBtn("正在登陆，请稍后...", "关闭", new SimpleCallback() {
            @Override
            public void onCallback(Object data) {

            }
        });

        mHandler.sendEmptyMessageDelayed(2, 1000);
    }

    Handler mHandler = new Handler() {
        @Override
        public void dispatchMessage(Message msg) {
            super.dispatchMessage(msg);
            switch (msg.what) {
                case 0:
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                    break;
                case 1:
                    LoadSuccess("登录成功");
                    mHandler.sendEmptyMessageDelayed(0, 500);
                    break;
                case 2:
                    LoadFail("登陆失败");
                    mHandler.sendEmptyMessageDelayed(3, 500);
                    break;
                case 3:
                    startActivity(new Intent(LoginActivity.this, OldMainActivity.class));
                    break;
            }
        }
    };

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (SoftInputUtil.isShouldHideInput(v, ev)) {
                if (SoftInputUtil.hideSoftInput(this, v)) {
                    //return true; //隐藏键盘时，其他控件不响应点击事件==》注释则不拦截点击事件
                }
            }
        }
        return super.dispatchTouchEvent(ev);
    }
}

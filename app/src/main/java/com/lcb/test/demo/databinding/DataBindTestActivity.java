package com.lcb.test.demo.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.lcb.test.R;
import com.lcb.test.databinding.ActivityDataBindTestBinding;
import com.lcb.test.formal.base.BaseActivity;

public class DataBindTestActivity extends BaseActivity {

    ActivityDataBindTestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(DataBindTestActivity.this, R.layout.activity_data_bind_test);

        binding.btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserModel user = new UserModel("张三", 21);
                binding.setUser(user);
            }
        });
        binding.setBtn1("事件绑定1");
        binding.setBtn2("事件绑定2");
        binding.setBtn3("事件绑定3");
        binding.setBtn4("change Ok");

        binding.setEvent(new EventListener() {
            @Override
            public void click1(View v) {
                binding.setBtn1("事件1绑定huidio");
            }

            @Override
            public void click2(View v) {
                binding.setBtn2("事件2绑定回调");
            }

            @Override
            public void click3(String s) {
                binding.setBtn3(s);
            }
        });
    }
}

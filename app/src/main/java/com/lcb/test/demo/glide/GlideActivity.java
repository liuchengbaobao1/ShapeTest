package com.lcb.test.demo.glide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lcb.test.R;
import com.lcb.test.formal.base.BaseActivity;

/**
 * Created by chengbao.liu on 2018/11/30.
 */

public class GlideActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glide_activity);

        ImageView iv = (ImageView) findViewById(R.id.iv_glide);

        String url = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg";
        Glide.with(this).load(url).into(iv);
    }
}

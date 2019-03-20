package com.lcb.test.demo.dagger;


import javax.inject.Inject;

/**
 * Created by baocheng.liu on 2017/8/30.
 */

public class Rose {
    @Inject
    public Rose() {
    }

    public String whisper() {
        return "dagger2使用测试";
    }
}

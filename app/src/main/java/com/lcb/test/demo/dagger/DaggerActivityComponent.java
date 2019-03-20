package com.lcb.test.demo.dagger;


import dagger.Component;

/**
 * Created by baocheng.liu on 2017/8/30.
 */
@Component
public interface DaggerActivityComponent {

    void inject(DaggerActivity activity);
}

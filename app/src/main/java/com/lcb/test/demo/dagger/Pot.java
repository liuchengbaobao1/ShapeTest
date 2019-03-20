package com.lcb.test.demo.dagger;


import javax.inject.Inject;

/**
 * Created by baocheng.liu on 2017/8/30.
 */

public class Pot {

    private Rose rose;

    @Inject
    public Pot(Rose rose) {
        this.rose = rose;
    }

    public String show() {
        return rose.whisper();
    }
}

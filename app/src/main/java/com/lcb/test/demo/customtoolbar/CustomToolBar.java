package com.lcb.test.demo.customtoolbar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;

/**
 * Created by baocheng.liu on 2017/3/23.
 */

public class CustomToolBar extends Toolbar {
    public CustomToolBar(Context context) {
        super(context);
    }

    public CustomToolBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}

package com.lcb.test.formal.view.immersive;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lcb.test.R;

/**
 * author  : Hacknife
 * e-mail  : 4884280@qq.com
 * github  : http://github.com/hacknife
 * project : Immersive
 */
public class StatusView extends View {


    public StatusView(Context context) {
        this(context,null);
    }

    public StatusView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public StatusView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setId(R.id.status);
    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = ImmersiveHelper.getStatusBarHeight(getContext());
        setMeasuredDimension(width, height);
    }
}

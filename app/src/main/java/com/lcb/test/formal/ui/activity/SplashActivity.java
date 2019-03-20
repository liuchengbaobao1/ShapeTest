package com.lcb.test.formal.ui.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

import com.lcb.test.R;
import com.lcb.test.formal.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity implements Runnable {

    @BindView(R.id.fab)
    FloatingActionButton mFab;
    @BindView(R.id.tv_splash)
    TextView mTvSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        mFab.postDelayed(this, 200);
    }

    @Override
    public void run() {
        final View parentView = (View) mFab.getParent();
        float scale = (float) (Math.sqrt(parentView.getHeight() * parentView.getHeight() + parentView.getWidth() * parentView.getWidth()) / mFab.getHeight());
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", scale);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", scale);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(mFab, scaleX, scaleY).setDuration(2800);
        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                parentView.setBackgroundColor(ContextCompat.getColor(SplashActivity.this, R.color.colorPrimary));
                mFab.setVisibility(View.GONE);
                mTvSplash.setVisibility(View.VISIBLE);
            }
        });
        PropertyValuesHolder holderA = PropertyValuesHolder.ofFloat("alpha", 0, 1);
        PropertyValuesHolder holderYm = PropertyValuesHolder.ofFloat("translationT", 0, 300);
        ObjectAnimator textAnimator = ObjectAnimator.ofPropertyValuesHolder(mTvSplash, holderA, holderYm).setDuration(2000);
        textAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        textAnimator.setStartDelay(1800);
        textAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                finish();
            }
        });
        objectAnimator.start();
        textAnimator.start();
    }
}

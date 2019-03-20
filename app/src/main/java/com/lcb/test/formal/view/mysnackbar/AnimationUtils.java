package com.lcb.test.formal.view.mysnackbar;


import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;

public class AnimationUtils {
    static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();//直线插补器（匀速）
    static final Interpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new FastOutSlowInInterpolator();//基于贝塞尔曲线的插补器 效果：依次 慢快慢
    static final Interpolator FAST_OUT_LINEAR_IN_INTERPOLATOR = new FastOutLinearInInterpolator();//MaterialDesign基于贝塞尔曲线的插补器 效果：依次 慢慢快
    static final Interpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR = new LinearOutSlowInInterpolator();//MaterialDesign基于贝塞尔曲线的插补器 效果：依次 快慢慢
    static final Interpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();//减速插补器（先快后慢）
    static final Interpolator ACCELERATE_DECELERATE_INTERPOLATOR = new AccelerateDecelerateInterpolator(); //加速减速插补器（先慢后快再慢）
    static final Interpolator ACCELERATE_INTERPOLATOR = new AccelerateInterpolator(); //加速插补器（先慢后快）
    static final Interpolator ANTICIPATE_INTERPOLATOR = new AnticipateInterpolator(); //向前插补器（先往回跑一点，再加速向前跑）
    static final Interpolator ANTICIPATE_OVER_SHOOT_INTERPOLATOR = new AnticipateOvershootInterpolator(); //向前向后插补器（先往回跑一点，再向后跑一点，再回到终点）
    static final Interpolator BOUNCE_INTERPOLATOR = new BounceInterpolator(); //反弹插补器（在动画结束的时候回弹几下，如果是竖直向下运动的话，就是玻璃球下掉弹几下的效果）
    static final Interpolator CYCLE_INTERPOLATOR = new CycleInterpolator(4); //循环插补器（按指定的路径以指定时间（或者是偏移量）的1/4、变速地执行一遍，再按指定的轨迹的相反反向走1/2的时间，再按指定的路径方向走完剩余的1/4的时间，最后回到原点。假如：默认是让a从原点往东跑100米。它会先往东跑100米，然后往西跑200米，再往东跑100米回到原点。可在代码中指定循环的次数）
    static final Interpolator OVER_SHOOT_INTERPOLATOR = new OvershootInterpolator(); //超出插补器（向前跑直到越界一点后，再往回跑）

    /**
     * Linear interpolation between {@code startValue} and {@code endValue} by {@code fraction}.
     */
    static float lerp(float startValue, float endValue, float fraction) {
        return startValue + (fraction * (endValue - startValue));
    }

    static int lerp(int startValue, int endValue, float fraction) {
        return startValue + Math.round(fraction * (endValue - startValue));
    }

    static class AnimationListenerAdapter implements Animation.AnimationListener {
        @Override
        public void onAnimationStart(Animation animation) {
        }

        @Override
        public void onAnimationEnd(Animation animation) {
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
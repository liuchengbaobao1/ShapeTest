package com.lcb.test.demo.custom;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lcb.test.formal.utils.DensityUtils;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by baocheng.liu on 2017/8/9.
 */

public class IndicatorMain {

    private static IndicatorMain instance;
    private FragmentActivity mActivity;
    private ArrayList<HashMap<String, Object>> mListData;

    private Fragment[] mFragments;
    private View[] mTabs;
    private LinearLayout mContainer;
    private int mCurrentTabIndex = 0;
    private int mIndex;

    private int lineColor;//横线颜色

    public static IndicatorMain getInstance() {
        if (instance == null)
            instance = new IndicatorMain();
        return instance;
    }

    public void init(FragmentActivity activity) {
        this.mActivity = activity;
        mListData = new ArrayList<>();
    }

    /**
     * 添加Fragment及Tab相关参数
     *
     * @param mFragment  Fragment
     * @param resId      TAB显示图片
     * @param strId      TAB显示文字
     * @param strColorId TAB字体颜色
     */
    public void addFragment(Fragment mFragment, int resId, int strId, int strColorId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("fragment", mFragment);
        map.put("icon", resId);
        map.put("title", strId);
        map.put("textcolor", strColorId);
        mListData.add(map);
    }

    public void create(RelativeLayout relativeLayout) {
        if (mListData == null || mListData.isEmpty()) {
            return;
        }
        //当前选项卡大于总选项卡设置默认显示第一个
        if (mCurrentTabIndex >= mListData.size()) {
            mCurrentTabIndex = 0;
        }
        relativeLayout.removeAllViews();

        mTabs = new View[mListData.size()];
        mFragments = new Fragment[mListData.size()];
        // 生成底部选显卡
        LinearLayout tabLinear = generateTab(mActivity);
        // 生成横线
        View line = generateLine(mActivity);
        // 设置fragment占位
        mContainer = generateContainer(mActivity);
        line.setBackgroundResource(lineColor);
        for (int i = 0; i < mListData.size(); i++) {
            TextView tv = generateText(mActivity);
            tv.setText(mActivity.getResources().getString((int) mListData.get(i).get("title")));
            tv.setCompoundDrawablesRelativeWithIntrinsicBounds(0, (int) mListData.get(i).get("icon"), 0, 0);
            tv.setTextColor(mActivity.getResources().getColorStateList((int) mListData.get(i).get("textcolor")));
            tv.setOnClickListener(mOnTabClickListener);
            tv.setTag(i);
            mTabs[i] = tv;
            mFragments[i] = (Fragment) mListData.get(i).get("fragment");
            tabLinear.addView(tv);
        }
        // 设置默认显示
        mTabs[mCurrentTabIndex].setSelected(true);
        // 设置Tab栏显示在底部
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);
        relativeLayout.addView(tabLinear, params);
        // 设置横线
        RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, DensityUtils.dp2px(mActivity, 0.5f));
        params3.addRule(RelativeLayout.ABOVE, tabLinear.getId());
        relativeLayout.addView(line, params3);
        // 设置容器
        RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        params2.addRule(RelativeLayout.ALIGN_PARENT_TOP, -1);
        params2.addRule(RelativeLayout.ABOVE, line.getId());
        relativeLayout.addView(mContainer, params2);
    }

    /**
     * 显示
     */
    public void show() {
        initTab();
    }

    /**
     * 初始化默认Fragment
     */
    public void initTab() {
        FragmentTransaction tran = mActivity.getSupportFragmentManager().beginTransaction();
        if (mFragments != null) {
            for (Fragment fg : mFragments) {
                if (fg.isAdded()) {
                    tran.remove(mActivity.getSupportFragmentManager().findFragmentByTag(fg.getClass().getSimpleName()));
                }
            }
        }
        tran.add(mContainer.getId(), mFragments[mCurrentTabIndex], mFragments[mCurrentTabIndex].getClass().getSimpleName()).show(mFragments[mCurrentTabIndex]).commitAllowingStateLoss();
    }

    /**
     * 设置TAB点击事件
     */
    private View.OnClickListener mOnTabClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setTab(Integer.parseInt(String.valueOf(v.getTag())));
        }
    };

    /**
     * 切换容器Fragment
     *
     * @param index
     */
    public void setTab(int index) {
        mIndex = index;
        if (mCurrentTabIndex != mIndex) {
            FragmentTransaction trx = mActivity.getSupportFragmentManager().beginTransaction();
            trx.hide(mFragments[mCurrentTabIndex]);
            if (!mFragments[mIndex].isAdded()) {
                trx.add(mContainer.getId(), mFragments[mIndex], mFragments[mIndex].getClass().getSimpleName());
            }
            trx.show(mFragments[mIndex]).commitAllowingStateLoss();

            mTabs[mCurrentTabIndex].setSelected(false);
            mTabs[mIndex].setSelected(true);
            mCurrentTabIndex = mIndex;
        }
    }

    /***
     * 设置默认显示Fragment
     *
     * @param defaultFragment
     */
    public void setDefaultFragment(int defaultFragment) {
        mCurrentTabIndex = defaultFragment;
    }

    /**
     * 设置横线的颜色
     *
     * @param resId
     */
    public void setLineColor(int resId) {
        lineColor = resId;
    }

    /**
     * 生成TextView
     *
     * @param ctx
     * @return
     */
    public TextView generateText(Context ctx) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        params.gravity = Gravity.CENTER;
        params.weight = 1;
        TextView textView = new TextView(ctx);
        textView.setGravity(Gravity.CENTER);
        textView.setLayoutParams(params);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 13f);
        return textView;
    }

    /**
     * 生成底部选项卡
     *
     * @param ctx
     * @return
     */
    public LinearLayout generateTab(Context ctx) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout linear = new LinearLayout(ctx);
        linear.setOrientation(LinearLayout.HORIZONTAL);
        linear.setGravity(Gravity.CENTER);
        linear.setLayoutParams(params);
        @IdRes int i = 1;
        linear.setId(i);
        return linear;
    }

    /**
     * 生成容器，用于替换Fragment
     *
     * @param ctx
     * @return
     */
    public LinearLayout generateContainer(Context ctx) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout linear = new LinearLayout(ctx);
        linear.setOrientation(LinearLayout.HORIZONTAL);
        linear.setGravity(Gravity.CENTER);
        linear.setLayoutParams(params);
        @IdRes int i = 2;
        linear.setId(i);
        return linear;
    }

    /**
     * 生成TAB选项卡上的横线
     *
     * @param ctx
     * @return
     */
    public View generateLine(Context ctx) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        View view = new View(ctx);
        view.setLayoutParams(params);
        @IdRes int i = 3;
        view.setId(i);
        return view;
    }
}

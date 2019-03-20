package com.lcb.test.demo;

import com.lcb.test.demo.CollapsingToolbarLayout.AppBarLayoutActivity;
import com.lcb.test.demo.Float.FloatLabeledEditTextActivity;
import com.lcb.test.demo.LeakCanaryActivity.LeakCanaryActivity;
import com.lcb.test.demo.RxjavaRetrofitOkHttp.RxJavaLoginTestActivity;
import com.lcb.test.demo.base.BaseListActivity;
import com.lcb.test.demo.calendar.CalendarActivity;
import com.lcb.test.demo.custom.IndicatorMainActivity;
import com.lcb.test.demo.customtoolbar.CustomToolBarActivity;
import com.lcb.test.demo.dagger.DaggerActivity;
import com.lcb.test.demo.databinding.DataBindTestActivity;
import com.lcb.test.demo.fragmentinactivity.activity.FragmentInActivity;
import com.lcb.test.demo.glide.GlideActivity;
import com.lcb.test.demo.leftdelete.LeftDeleteActivity;
import com.lcb.test.demo.lifecycler.LifeAActivity;
import com.lcb.test.demo.materialdesign.view.MySnackbarActiviyt;
import com.lcb.test.demo.mvp.activity.MvpLoginActivity;
import com.lcb.test.demo.flowlayout.FlowLayoutActivity;
import com.lcb.test.demo.style.Style1Activity;
import com.lcb.test.demo.vue.VueActivity;

public class OldMainActivity extends BaseListActivity {

    public Class<?>[] ACTIVITYS = {
            Style1Activity.class,
            FloatLabeledEditTextActivity.class,
            AppBarLayoutActivity.class,
            MySnackbarActiviyt.class,
            CustomToolBarActivity.class,
            IndicatorMainActivity.class,
            RxJavaLoginTestActivity.class,
            DataBindTestActivity.class,
            MvpLoginActivity.class,
            FragmentInActivity.class,
            DaggerActivity.class,
            VueActivity.class,
            CalendarActivity.class,
            LeftDeleteActivity.class,
            LeakCanaryActivity.class,
            GlideActivity.class,
            LifeAActivity.class,
            FlowLayoutActivity.class};

    public String[] TITLE = {
            "样式开发",
            "float",
            "AppBarLayout",
            "自定义SnackBar",
            "通用标题栏",
            "自定义主页面类",
            "Rxjava+Retrofit+OkHttp",
            "Data Binding",
            "MVP",
            "Fragment嵌套Activity",
            "dagger",
            "VUE",
            "日历对话框",
            "左滑删除",
            "内存检测LeakCanary",
            "Glide",
            "生命周期测试",
            "FlowLayout"};

    @Override
    public Class<?>[] getActivitys() {
        return ACTIVITYS;
    }

    @Override
    public String[] getTitles() {
        return TITLE;
    }
}

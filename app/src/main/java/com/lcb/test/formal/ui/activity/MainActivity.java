package com.lcb.test.formal.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.lcb.test.R;
import com.lcb.test.formal.base.BaseActivity;
import com.lcb.test.formal.ui.adapter.TabFragmentAdapter;
import com.lcb.test.formal.ui.fragment.TabFragmentFive;
import com.lcb.test.formal.ui.fragment.TabFragmentFour;
import com.lcb.test.formal.ui.fragment.TabFragmentOne;
import com.lcb.test.formal.ui.fragment.TabFragmentSeven;
import com.lcb.test.formal.ui.fragment.TabFragmentSix;
import com.lcb.test.formal.ui.fragment.TabFragmentThree;
import com.lcb.test.formal.ui.fragment.TabFragmentTwo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements Toolbar.OnMenuItemClickListener {

    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.navigationView)
    NavigationView navigationView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabs)
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initToolbar();
        initTabLayout();
        initListener();
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("我的博客");
//        toolbar.setSubtitle("CSDN");
//        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setNavigationIcon(R.drawable.ic_list_black_24dp);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setOnMenuItemClickListener(this);
    }

    private void initTabLayout() {
        List<String> tabList = new ArrayList<>();
        tabList.add("图片");
        tabList.add("体育");
        tabList.add("新闻");
        tabList.add("娱乐");
        tabList.add("综艺");
        tabList.add("财产");
        tabList.add("房产");
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);//设置tab模式，当前为系统默认模式
        //此处代码设置无效，不知道为啥？？？xml属性是可以的
//        tabLayout.setTabTextColors(android.R.color.white, android.R.color.holo_red_dark);//设置TabLayout两种状态
        tabLayout.addTab(tabLayout.newTab().setText(tabList.get(0)));//添加tab选项卡
        tabLayout.addTab(tabLayout.newTab().setText(tabList.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(tabList.get(2)));
        tabLayout.addTab(tabLayout.newTab().setText("娱乐"));
        tabLayout.addTab(tabLayout.newTab().setText("综艺"));
        tabLayout.addTab(tabLayout.newTab().setText("财产"));
        tabLayout.addTab(tabLayout.newTab().setText("房产"));

        List<Fragment> fragmentList = new ArrayList<>();
        Fragment f1 = new TabFragmentOne();
        Bundle bundle = new Bundle();
        bundle.putString("content", "CSDN 我的博客");
        f1.setArguments(bundle);
        fragmentList.add(f1);
        fragmentList.add(new TabFragmentTwo());
        fragmentList.add(new TabFragmentThree());
        fragmentList.add(new TabFragmentFour());
        fragmentList.add(new TabFragmentFive());
        fragmentList.add(new TabFragmentSix());
        fragmentList.add(new TabFragmentSeven());

        TabFragmentAdapter fragmentAdapter = new TabFragmentAdapter(getSupportFragmentManager(), fragmentList, tabList);
        viewPager.setAdapter(fragmentAdapter);//给ViewPager设置适配器
        tabLayout.setupWithViewPager(viewPager);//将TabLayout和ViewPager关联起来。
        tabLayout.setTabsFromPagerAdapter(fragmentAdapter);//给Tabs设置适配器
    }

    private void initListener() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Success("测试弹出提示");
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.sub_exit:
                        finish();
                        break;
                    case R.id.sub_switch:
                        break;
                    case R.id.nav_blog:
//                        startActivity(new Intent(MainActivity.this, BlogActivity.class));
                        break;
                    case R.id.nav_ver:
                        break;
                    case R.id.nav_about:
                        break;
                }
                item.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                Success("查找按钮");
                break;
            case R.id.action_share:
                Success("分享按钮");
                break;
        }
        return true;
    }
}

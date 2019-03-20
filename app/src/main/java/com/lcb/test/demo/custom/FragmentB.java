package com.lcb.test.demo.custom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.lcb.test.R;

/**
 * Created by baocheng.liu on 2017/8/9.
 */

public class FragmentB extends Fragment implements View.OnClickListener, Toolbar.OnMenuItemClickListener {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7;

    Toolbar toolbar;

    AppCompatActivity mAppCompatActivity;

    ActionBar actionBar;

    Menu mMenu;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btn1 = (Button) getActivity().findViewById(R.id.btn1);
        btn2 = (Button) getActivity().findViewById(R.id.btn2);
        btn3 = (Button) getActivity().findViewById(R.id.btn3);
        btn4 = (Button) getActivity().findViewById(R.id.btn4);
        btn5 = (Button) getActivity().findViewById(R.id.btn5);
        btn6 = (Button) getActivity().findViewById(R.id.btn6);
        btn7 = (Button) getActivity().findViewById(R.id.btn7);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);

        mAppCompatActivity = (AppCompatActivity) getActivity();
        toolbar = (Toolbar) mAppCompatActivity.findViewById(R.id.toolbar);
        mAppCompatActivity.setSupportActionBar(toolbar);
        actionBar = mAppCompatActivity.getSupportActionBar();

        toolbar.setOnMenuItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                //显示标题和副标题
                actionBar.setDisplayShowTitleEnabled(true);
                toolbar.setTitle("标题");
                toolbar.setSubtitle("副标题");
                break;
            case R.id.btn2:
                //返回按钮
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setHomeButtonEnabled(true);
                setHasOptionsMenu(true);//这个需要，不然onOptionsItemSelected方法不会被调用
                //必须是android.R.id.home
                break;
            case R.id.btn3:
                //显示应用Logo
                actionBar.setDisplayShowHomeEnabled(true);
                actionBar.setDisplayUseLogoEnabled(true);
                actionBar.setLogo(R.mipmap.ic_launcher);
                break;
            case R.id.btn4:
                //显示导航按钮
                toolbar.setNavigationIcon(R.drawable.ic_account_balance_black_24dp);
                break;
            case R.id.btn5:
                toolbar.setTitle("左文字左文字");
                toolbar.setSubtitle("");
                toolbar.setNavigationIcon(null);
                actionBar.setLogo(null);
                actionBar.setDisplayHomeAsUpEnabled(false);
                if (mMenu != null)
                    mMenu.clear();
                break;
            case R.id.btn6:

                break;
            case R.id.btn7:

                break;
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(getActivity(), "返按钮牛", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_edit:
                Toast.makeText(getActivity(), "右文字", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        mMenu = menu;
        final MenuItem item = menu.findItem(R.id.action_edit);
        item.getActionView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(item);
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                Toast.makeText(getActivity(), "查找按钮", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_share:
                Toast.makeText(getActivity(), "分享按钮", Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }
}

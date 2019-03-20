package com.lcb.test.demo.custom;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.lcb.test.R;

public class IndicatorMainActivity extends AppCompatActivity implements FragmentD.OnFinishActivityCallback {

    FragmentA mFragmentA;
    FragmentB mFragmentB;
    FragmentC mFragmentC;
    FragmentD mFragmentD;

    private Fragment[] mFragments;
    private int mIndex;
    private int mCurrentTabIndex;
    private View[] mTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicator_main);

        initUI();
        initListener();
    }

    private void initUI() {
        mTabs = new View[4];
        mTabs[0] = findViewById(R.id.btn_main_msg);
        mTabs[1] = findViewById(R.id.btn_main_contant);
        mTabs[2] = findViewById(R.id.btn_main_workbench);
        mTabs[3] = findViewById(R.id.btn_main_me);
        mTabs[1].setSelected(true);
        mCurrentTabIndex = 1;
        initTab();
    }

    public void initTab() {

        FragmentTransaction tran = getSupportFragmentManager().beginTransaction();

        if (mFragments != null) {
            for (Fragment fg : mFragments) {
                if (fg.isAdded()) {
                    tran.remove(getSupportFragmentManager().findFragmentByTag(fg.getClass().getSimpleName()));
                }
            }
        }

        mFragmentA = new FragmentA();
        mFragmentB = new FragmentB();
        mFragmentC = new FragmentC();
        mFragmentD = new FragmentD();
        mFragments = new Fragment[]{mFragmentA, mFragmentB, mFragmentC, mFragmentD};
        tran.add(R.id.fragment_container, mFragmentB, mFragmentB.getClass().getSimpleName()).show(mFragmentB).commitAllowingStateLoss();
    }

    private void initListener() {
        for (View v : mTabs) {
            v.setOnClickListener(mOnTabClickListener);
        }
    }

    private View.OnClickListener mOnTabClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setTab(Integer.parseInt(String.valueOf(v.getTag())));
        }
    };

    public void setTab(int index) {
        mIndex = index;
        if (mCurrentTabIndex != mIndex) {
            FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
            trx.hide(mFragments[mCurrentTabIndex]);
            if (!mFragments[mIndex].isAdded()) {
                trx.add(R.id.fragment_container, mFragments[mIndex], mFragments[mIndex].getClass().getSimpleName());
            }
            trx.show(mFragments[mIndex]).commitAllowingStateLoss();

            mTabs[mCurrentTabIndex].setSelected(false);
            mTabs[mIndex].setSelected(true);
            mCurrentTabIndex = mIndex;
        }
    }

    @Override
    public void onFinish() {
        Toast.makeText(this, "即将关闭", Toast.LENGTH_LONG).show();
        finish();
    }
}

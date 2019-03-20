package com.lcb.test.demo.custom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.lcb.test.R;

public class IndicatorMainActivity1 extends AppCompatActivity implements FragmentD.OnFinishActivityCallback{

    IndicatorMain mIndicatorMain;

    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicator_main1);
        mIndicatorMain = IndicatorMain.getInstance();

        initUI();
    }

    private void initUI() {
        relativeLayout = (RelativeLayout) findViewById(R.id.fragment_container);
        mIndicatorMain.init(this);
        mIndicatorMain.setDefaultFragment(1);
        mIndicatorMain.setLineColor(R.color.common_item_sep_line);
        mIndicatorMain.addFragment(new FragmentA(), R.drawable.sel_bg_home_chat, R.string.aaaa, R.color.sel_txt_main_color);
        mIndicatorMain.addFragment(new FragmentB(), R.drawable.sel_bg_home_contact, R.string.bbbb, R.color.sel_txt_main_color);
        mIndicatorMain.addFragment(new FragmentC(), R.drawable.sel_bg_home_workbench, R.string.cccc, R.color.sel_txt_main_color);
        mIndicatorMain.addFragment(new FragmentD(), R.drawable.sel_bg_home_me, R.string.dddd, R.color.sel_txt_main_color);
        mIndicatorMain.create(relativeLayout);
        mIndicatorMain.show();
    }

    @Override
    public void onFinish() {
        Toast.makeText(this, "关闭页面", Toast.LENGTH_LONG).show();
        finish();
    }
}

package com.lcb.test.demo.CollapsingToolbarLayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lcb.test.R;

public class CollapsingToolbarLayoutActivity extends AppCompatActivity {

    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        if (1 == index) {

        } else if (2 == index) {

        } else if (3 == index) {

        }
        setContentView(R.layout.activity_collapsing_toolbar_layout);
    }

    private void initData() {
        index = getIntent().getIntExtra("index", 1);
    }
}

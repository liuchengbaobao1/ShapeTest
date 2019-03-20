package com.lcb.test.demo.style;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lcb.test.R;


public class Style3Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style3);
    }

    public void startnext2(View v) {
        startActivity(new Intent(this, Style4Activity.class));
    }
}

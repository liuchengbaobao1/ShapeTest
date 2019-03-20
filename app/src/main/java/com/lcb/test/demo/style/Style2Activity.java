package com.lcb.test.demo.style;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lcb.test.R;


public class Style2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style2);
    }

    public void startnext1(View v) {
        startActivity(new Intent(this, Style3Activity.class));
    }
}

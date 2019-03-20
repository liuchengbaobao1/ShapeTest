package com.lcb.test.demo.style;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lcb.test.R;


public class Style1Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style);
    }

    public void startnext(View v) {
        startActivity(new Intent(this, Style2Activity.class));
    }

    public void startnext3(View v) {
        startActivity(new Intent(this, Style5Activity.class));
    }

    public void startnext4(View view) {
        startActivity(new Intent(this, Style6Activity.class));
    }

    public void startnext5(View v) {
        startActivity(new Intent(this, Style7Activity.class));
    }

    public void startnext6(View view) {
        startActivity(new Intent(this, Style8Activity.class));
    }
}

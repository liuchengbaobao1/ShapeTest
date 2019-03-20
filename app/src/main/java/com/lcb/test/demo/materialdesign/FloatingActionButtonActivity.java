package com.lcb.test.demo.materialdesign;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lcb.test.R;


public class FloatingActionButtonActivity extends AppCompatActivity {

    private RelativeLayout layout;
    CoordinatorLayout coordinatorlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_action_button);

        layout = (RelativeLayout) findViewById(R.id.activity_floating_action_button);
        coordinatorlayout = (CoordinatorLayout) findViewById(R.id.coordinatorlayout);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FloatingActionButtonActivity.this, TextInputLayoutActivity.class));
            }
        });

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Snackbar snackbar = Snackbar.make(layout, "测试弹出提示", Snackbar.LENGTH_INDEFINITE);
                snackbar.show();
                snackbar.setAction("打开", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(FloatingActionButtonActivity.this, TabLayoutActivity.class));
                    }
                });

                View mView = snackbar.getView();
                mView.setBackgroundColor(Color.BLUE);
                //click的字体颜色
                snackbar.setActionTextColor(Color.GREEN);
                //内容的字体颜色与大小
                TextView tvSnackbarText = (TextView) mView.findViewById(android.support.design.R.id.snackbar_text);
                tvSnackbarText.setText("hello world");
                tvSnackbarText.setTextColor(Color.RED);
                tvSnackbarText.setTextSize(30);
            }
        });

        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(coordinatorlayout, "测试弹出提示", Snackbar.LENGTH_INDEFINITE).show();
            }
        });

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FloatingActionButtonActivity.this, NavigationViewActivity.class));
            }
        });
    }
}

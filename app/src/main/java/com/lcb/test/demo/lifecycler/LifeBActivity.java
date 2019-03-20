package com.lcb.test.demo.lifecycler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.lcb.test.R;
import com.lcb.test.formal.base.BaseActivity;

/**
 * Created by chengbao.liu on 2018/12/12.
 */

public class LifeBActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_b);
        Log.d("lcb", "----------B------------onCreate");
        Button btnB = (Button) findViewById(R.id.btn_b);
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button btnReplace = (Button) findViewById(R.id.btn_replace);
        btnReplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,new LifeBFragment()).commit();
            }
        });

        Button btnAdd = (Button) findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().add(R.id.fragment_container,new LifeBFragment()).commit();
            }
        });
        getFragmentManager().beginTransaction().add(R.id.fragment_container, new LifeAFragment()).commit();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lcb", "----------B------------onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lcb", "----------B------------onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lcb", "----------B------------onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lcb", "----------B------------onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lcb", "----------B------------onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lcb", "----------B------------onDestroy");
    }
}

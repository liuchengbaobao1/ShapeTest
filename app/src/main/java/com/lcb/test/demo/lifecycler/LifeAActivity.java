package com.lcb.test.demo.lifecycler;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.lcb.test.R;
import com.lcb.test.formal.base.BaseActivity;

/**
 * Created by chengbao.liu on 2018/12/12.
 */

public class LifeAActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_a);
        Button btnA = (Button) findViewById(R.id.btn_a);
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LifeBActivity.class));
            }
        });

        Log.d("lcb","----------A------------onCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lcb","----------A------------onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lcb","----------A------------onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lcb","----------A------------onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lcb","----------A------------onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lcb","----------A------------onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lcb","----------A------------onDestroy");
    }
}

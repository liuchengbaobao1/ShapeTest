package com.lcb.test.demo.dagger;

import android.os.Bundle;
import android.widget.Toast;

import com.lcb.test.R;
import com.lcb.test.formal.base.BaseActivity;

import javax.inject.Inject;


public class DaggerActivity extends BaseActivity {

    @Inject
    Pot pot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);

        DaggerDaggerActivityComponent.builder().build().inject(this);

        Toast.makeText(this, pot.show(), Toast.LENGTH_LONG).show();
    }
}

package com.lcb.test.demo.style;

import android.app.Activity;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.lcb.test.R;


public class Style6Activity extends Activity {
    boolean istransition = false;
    TransitionDrawable transition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style6);
        //level-list 标签
        ImageView level_list = (ImageView) findViewById(R.id.level_list);
        level_list.getDrawable().setLevel(80);
        //transition 标签
        transition = (TransitionDrawable) getResources().getDrawable(R.drawable.bg_transition);
        final ImageView transition_img = (ImageView) findViewById(R.id.transition);
        transition_img.setImageDrawable(transition);

        transition_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                istransition = !istransition;
                if (istransition) {
                    transition.startTransition(1500);
                } else {
                    transition.reverseTransition(1500);
                }
            }
        });

        //clip标签
        ImageView clip = (ImageView) findViewById(R.id.clip);
        clip.getDrawable().setLevel(8000);

        //scale标签
        ImageView scale = (ImageView) findViewById(R.id.scale);
        scale.getDrawable().setLevel(8000);
    }
}

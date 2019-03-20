package com.lcb.test.demo.custom;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lcb.test.R;

/**
 * Created by baocheng.liu on 2017/8/9.
 */

public class FragmentD extends Fragment {

    TextView tvContent;

    private OnFinishActivityCallback finishActivityCallback;

    public interface OnFinishActivityCallback {
        void onFinish();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnFinishActivityCallback) {
            finishActivityCallback = (OnFinishActivityCallback) activity;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvContent = (TextView) getView().findViewById(R.id.tv_content);
        tvContent.setText("DDDD");
        tvContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishActivityCallback.onFinish();
            }
        });
    }
}

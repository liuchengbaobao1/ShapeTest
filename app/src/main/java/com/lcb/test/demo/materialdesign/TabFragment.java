package com.lcb.test.demo.materialdesign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lcb.test.R;

/**
 * Created by baocheng.liu on 2017/3/17.
 */

public class TabFragment extends Fragment {

    private String content;
    private View view;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_app_bar_item, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        content = getArguments().getString("content");
        TextView tvContent = (TextView) view.findViewById(R.id.item_tv);
        tvContent.setText(content + "");
    }
}

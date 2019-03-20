package com.lcb.test.demo.lifecycler;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lcb.test.R;

/**
 * Created by chengbao.liu on 2018/12/13.
 */

public class LifeAFragment extends Fragment {

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("lcb", "----------FragmentA------------onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("lcb", "----------FragmentA------------onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.d("lcb", "----------FragmentA------------onCreateView");
        return inflater.inflate(R.layout.fragment_life_a, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("lcb", "----------FragmentA------------onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("lcb", "----------FragmentA------------onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("lcb", "----------FragmentA------------onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("lcb", "----------FragmentA------------onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("lcb", "----------FragmentA------------onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("lcb", "----------FragmentA------------onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("lcb", "----------FragmentA------------onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("lcb", "----------FragmentA------------onDetach");
    }
}

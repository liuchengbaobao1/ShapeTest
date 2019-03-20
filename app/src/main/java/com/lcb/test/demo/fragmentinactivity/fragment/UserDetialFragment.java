package com.lcb.test.demo.fragmentinactivity.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lcb.test.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.internal.Preconditions;

/**
 * Created by baocheng.liu on 2017/12/7.
 */

public class UserDetialFragment extends Fragment {

    private static final String EXTRAS_USERNAME = "username";
    @BindView(R.id.tv_user_detial)
    TextView mTvDetial;

    public static UserDetialFragment forUser(String username) {
        final UserDetialFragment userDetailsFragment = new UserDetialFragment();
        final Bundle arguments = new Bundle();
        arguments.putString(EXTRAS_USERNAME, username);
        userDetailsFragment.setArguments(arguments);
        return userDetailsFragment;
    }

    public UserDetialFragment() {
        setRetainInstance(true);//非中断保存
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        System.out.println("onAttach--------------------------");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("onCreate--------------------------");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_user_detial, container, false);
        ButterKnife.bind(this, fragmentView);
        System.out.println("onCreateView--------------------------");
        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println("onViewCreated--------------------------");
        initUI();
    }

    private void initUI() {
        mTvDetial.setText(getCurrentUserName());
    }

    private String getCurrentUserName(){
        final Bundle arguments = getArguments();
        Preconditions.checkNotNull(arguments, "Fragment arguments cannot be null");
        return arguments.getString(EXTRAS_USERNAME);
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("onStart--------------------------");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("onResume--------------------------");
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("onPause--------------------------");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("onStop--------------------------");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("onDestroyView--------------------------");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy--------------------------");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("onDetach--------------------------");
    }
}

package com.lcb.test.demo.fragmentinactivity.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.lcb.test.R;
import com.lcb.test.demo.common.adapter.CommonAdapter;
import com.lcb.test.demo.common.adapter.ViewHolder;
import com.lcb.test.demo.fragmentinactivity.contract.UserContract;
import com.lcb.test.demo.fragmentinactivity.entity.UserEntity;
import com.lcb.test.demo.fragmentinactivity.presenter.UserPresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by baocheng.liu on 2017/12/7.
 */

public class UserListFragment extends Fragment implements UserContract.IView {

    UserListListener mUserListListener;
    UserPresenter mUserPresenter;
    Adapter mAdapter;
    @BindView(R.id.lv_user_list)
    ListView mListView;

    public UserListFragment() {
        setRetainInstance(true);//非中断保存
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof UserListListener) {
            mUserListListener = (UserListListener) activity;
        }
    }

    public interface UserListListener {
        void onUserClicked(final UserEntity userEntity);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_user_list, container, false);
        ButterKnife.bind(this,fragmentView);
        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUserPresenter = new UserPresenter(this);
        if (savedInstanceState == null) {
            initUI();
            initListener();
            loadUserList();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mUserListListener = null;
    }

    private void initUI(){
        mAdapter = new Adapter();
        mListView.setAdapter(mAdapter);
    }
    private void initListener(){
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mUserListListener.onUserClicked(mAdapter.getItem(i));
            }
        });
    }

    private void loadUserList() {
        mUserPresenter.reqUserList();
    }

    @Override
    public void showLoding(String msg) {

    }

    @Override
    public void dismissLoding(String msg) {

    }

    @Override
    public void onError(String msg) {

    }

    @Override
    public void onRespList(ArrayList<UserEntity> userList) {
        mAdapter.setListData(userList);
    }

    class Adapter extends CommonAdapter<UserEntity> {

        public Adapter() {
            super(getActivity(), R.layout.item_sample_recyclerview);
        }

        @Override
        public void convert(ViewHolder holder, UserEntity userEntity) {
            holder.setText(R.id.info_text, userEntity.usernName);
        }
    }

}

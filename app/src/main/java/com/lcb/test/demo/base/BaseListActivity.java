package com.lcb.test.demo.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lcb.test.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by baocheng.liu on 2017/9/14.
 */

public abstract class BaseListActivity extends AppCompatActivity {

    public abstract Class<?>[] getActivitys();

    public abstract String[] getTitles();

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar mToolBar;

    private ArrayList<ListItem> mDataList = null;
    private DataAdapter mDataAdapter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sample);
        ButterKnife.bind(this);

        setSupportActionBar(mToolBar);
        mToolBar.setTitle("Demo列表");

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mDataList = new ArrayList<>();
        for (int i = 0; i < getActivitys().length; i++) {
            ListItem item = new ListItem();
            item.title = getTitles()[i];
            item.activity = getActivitys()[i];
            mDataList.add(item);
        }
        mDataAdapter = new DataAdapter(this);
        mDataAdapter.setData(mDataList);
        mRecyclerView.setAdapter(mDataAdapter);
    }

    private class ListItem {
        public String title;
        public Class<?> activity;
    }

    private class DataAdapter extends RecyclerView.Adapter {

        private LayoutInflater mLayoutInflater;
        private ArrayList<ListItem> mDataList = new ArrayList<>();

        public DataAdapter(Context context) {
            mLayoutInflater = LayoutInflater.from(context);
        }

        public void setData(ArrayList<ListItem> list) {
            this.mDataList = list;
            notifyDataSetChanged();
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(mLayoutInflater.inflate(R.layout.item_sample_recyclerview, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            ListItem listItem = mDataList.get(position);
            ViewHolder viewHolder = (ViewHolder) holder;
            viewHolder.textView.setText(listItem.title);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ListItem listItem = mDataList.get(position);
                    startActivity(new Intent(BaseListActivity.this, listItem.activity));
                }
            });
        }

        @Override
        public int getItemCount() {
            return mDataList.size();
        }

        public List<ListItem> getDataList() {
            return mDataList;
        }

        private class ViewHolder extends RecyclerView.ViewHolder {
            private TextView textView;

            public ViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.info_text);
            }
        }
    }
}

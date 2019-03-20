package com.lcb.test.demo.leftdelete;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.lcb.test.R;
import com.lcb.test.formal.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengbao.liu on 2018/7/6.
 */

public class LeftDeleteActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_delete);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.addOnItemTouchListener(new SwipeItemLayout.OnSwipeItemTouchListener(getApplicationContext()));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext()));
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
        private Context mContext;
        private List<String> list;

        public MyAdapter(Context context) {
            mContext = context;

            list = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                list.add(String.valueOf(i));
            }
        }

        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            View root = LayoutInflater.from(mContext).inflate(R.layout.item_recycler_left_delete, parent, false);
            return new Holder(root);
        }

        @Override
        public void onBindViewHolder(Holder holder, int position) {
            holder.mTvTitle.setText(list.get(position));
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class Holder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
            private TextView mTvTitle;

            Holder(View itemView) {
                super(itemView);

                mTvTitle = itemView.findViewById(R.id.tv_title);
                View main = itemView.findViewById(R.id.main);
                main.setOnClickListener(this);
                main.setOnLongClickListener(this);

                View delete = itemView.findViewById(R.id.delete);
                delete.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.main:
                        Toast.makeText(v.getContext(), "点击了main，位置为：" + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.delete:
                        int pos = getAdapterPosition();
                        list.remove(pos);
                        notifyItemRemoved(pos);
                        break;
                }
            }

            @Override
            public boolean onLongClick(View v) {
                switch (v.getId()) {
                    case R.id.main:
                        Toast.makeText(v.getContext(), "长按了main，位置为：" + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        }
    }
}

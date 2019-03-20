package com.lcb.test.demo.CollapsingToolbarLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.lcb.test.R;

import java.util.ArrayList;
import java.util.List;

public class ScrollingActivity1 extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private NestedScrollView mNestedScrollView;

    private String[] mTitles = {"西游记1", "西游记2"};

    public static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = this;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏颜色
            window.setStatusBarColor(Color.TRANSPARENT);
            ViewGroup contentView = ((ViewGroup) findViewById(android.R.id.content));
            View childAt = contentView.getChildAt(0);
            if (childAt != null) {
                childAt.setFitsSystemWindows(true);
            }
        }
        setContentView(R.layout.activity_scrolling1);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mTabLayout = (TabLayout) findViewById(R.id.tablelayout);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mNestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);
        //设置 NestedScrollView 的内容是否拉伸填充整个视图，
        //这个设置是必须的，否者我们在里面设置的ViewPager会不可见
        mNestedScrollView.setFillViewport(true);
        mTabLayout.setupWithViewPager(mViewPager);
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
    }

    private class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new MyFragment();
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }
    }

    @SuppressLint("ValidFragment")
    public static class MyFragment extends Fragment {
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            String string = getString(R.string.large_text);
            List<String> strings = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                strings.add(string);
            }
            RecyclerView recyclerView = new RecyclerView(getActivity());
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            recyclerView.setAdapter(new MyListAdapter(strings));
            return recyclerView;
        }
    }

    static class MyListAdapter extends RecyclerView.Adapter {
        private List<String> mStrings;

        public MyListAdapter(List<String> strings) {
            this.mStrings = strings;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View convertView = LayoutInflater.from(mContext).inflate(R.layout.layout_app_bar_item, parent, false);
            return new MyListViewHolder(convertView);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            MyListViewHolder viewHolder = (MyListViewHolder) holder;
            viewHolder.mTextView.setText(mStrings.get(position));
        }

        @Override
        public int getItemCount() {
            return 2;
        }
    }

    static class MyListViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;

        public MyListViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.item_tv);
        }
    }
}

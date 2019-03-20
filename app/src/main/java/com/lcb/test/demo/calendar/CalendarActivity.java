package com.lcb.test.demo.calendar;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import com.lcb.test.R;
import com.lcb.test.formal.base.BaseActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by chengbao.liu on 2018/5/3.
 * 日历
 */

public class CalendarActivity extends BaseActivity {

    @BindView(R.id.textView)
    TextView mTv;
    @BindView(R.id.calendarView)
    CalendarView mCalendarView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_layout);
        ButterKnife.bind(this);

        //初始化日期、
        Calendar calender = Calendar.getInstance();
        String datat = calender.get(Calendar.YEAR) + "年" + (calender.get(Calendar.MONTH) + 1)
                + "月" + calender.get(Calendar.DAY_OF_MONTH) + "日";
        mTv.setText(datat);

        chooseCalender();
    }

    /**
     * 得到选择的日期
     */
    private void chooseCalender() {
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                updateTime(year, month, dayOfMonth, mTv);
            }
        });
    }

    @OnClick(R.id.btn_dialog)
    public void onClickDialog() {
        createDialogView(this, new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                updateTime(year, month, dayOfMonth, mTv);
            }
        });
    }

    private void updateTime(int year, int monthOfYear, int dayOfMonth, TextView textview) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, monthOfYear);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        textview.setText(df.format(calendar.getTime()));
    }

    public void createDialogView(Context context, final CalendarView.OnDateChangeListener listener) {
        final Dialog dialog = new Dialog(context, R.style.dialog_common);
        LayoutInflater inflater = LayoutInflater.from(context);
        View contentView = inflater.inflate(R.layout.layout_calendar, null);

        CalendarView calendarView = contentView.findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                listener.onSelectedDayChange(view, year, month, dayOfMonth);
                dialog.dismiss();
            }
        });
        dialog.setContentView(contentView);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

}

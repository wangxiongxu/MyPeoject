package com.wangxu.example.wnag.geeknews.activity;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.wangxu.example.wnag.geeknews.R;

public class RiLiActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mTool;
    private MaterialCalendarView mCalendarView;
    /**
     * 确认
     */
    private Button mBt;
    private String a="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ri_li);
        initView();
    }

    private void initView() {
        mTool = (Toolbar) findViewById(R.id.tool);
        mCalendarView = (MaterialCalendarView) findViewById(R.id.calendarView);
        mBt = (Button) findViewById(R.id.bt);
        mBt.setOnClickListener(this);
        mTool.setTitle("选择日期");
        mTool.setNavigationIcon(R.mipmap.ic_close);
        setSupportActionBar(mTool);
        mTool.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mCalendarView.state().edit().setFirstDayOfWeek(Calendar.MONDAY)
                .setMinimumDate(CalendarDay.from(2016, 4, 3))
                .setMaximumDate(CalendarDay.from(2020, 5, 12))
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();
        mCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView materialCalendarView, @NonNull CalendarDay calendarDay, boolean b) {
                Log.i("tag", "onDateSelected: "+calendarDay);
                int i = calendarDay.describeContents();
                String s = calendarDay.toString();
                String s1 = s.replaceAll("[a-zA-Z]", "");
                String substring = s1.substring(1, s1.length() - 1);
                String[] split = substring.split("-");
                a = "";
                a+=split[0];
                if (split[1].length() == 1) {
                    a += "0" + split[1];
                } else {
                    a+=split[1];
                }
                if (split[2].length() == 1) {
                    a += "0" + split[1];
                } else {
                    a+=split[2];
                }

                Log.i("tag", "onDateSelected: "+a);
                /*Log.i("tag", "onDateSelected: "+split[0]);
                Log.i("tag", "onDateSelected: "+split[1]);
                Log.i("tag", "onDateSelected: "+split[2]);*/


                /*for (char aChar : chars) {
                    if (aChar >= 48 && aChar <= 57) {
                        a+=aChar;
                    }
                }*/
                //Log.i("tag", "onDateSelected: "+a);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt:
                Intent intent = new Intent();
                if (a.isEmpty()) {
                    Toast.makeText(RiLiActivity.this,"选择",Toast.LENGTH_SHORT).show();
                    return;
                }
                intent.putExtra("1",a);
                setResult(200,intent);
                finish();
                break;
        }
    }
}

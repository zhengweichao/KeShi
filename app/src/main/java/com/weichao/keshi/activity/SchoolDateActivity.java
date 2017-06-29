package com.weichao.keshi.activity;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.tibolte.agendacalendarview.AgendaCalendarView;
import com.github.tibolte.agendacalendarview.CalendarPickerController;
import com.github.tibolte.agendacalendarview.models.BaseCalendarEvent;
import com.github.tibolte.agendacalendarview.models.CalendarEvent;
import com.github.tibolte.agendacalendarview.models.DayItem;
import com.weichao.keshi.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * @ 创建时间: 2017/5/23 on 11:47.
 * @ 描述：校历页面
 * @ 作者: 郑卫超 QQ: 2318723605
 */
public class SchoolDateActivity extends BaseActivity implements CalendarPickerController {

    @Override
    int getLayoutId() {
        return R.layout.activity_school_date;
    }

    @Override
    Activity getmActivity() {
        return null;
    }

    @Override
    void initView() {
        AgendaCalendarView mAgendaCalendarView = (AgendaCalendarView) findViewById(R.id.agenda_calendar_view);
        Calendar minDate = Calendar.getInstance();
        Calendar maxDate = Calendar.getInstance();

        minDate.add(Calendar.MONTH, -2);
        minDate.set(Calendar.DAY_OF_MONTH, 1);
        maxDate.add(Calendar.YEAR, 1);

        List<CalendarEvent> eventList = new ArrayList<>();
        mockList(eventList);

        mAgendaCalendarView.init(eventList, minDate, maxDate, Locale.getDefault(), this);
    }

    private void mockList(List<CalendarEvent> eventList) {
        Calendar startTime1 = Calendar.getInstance();
        Calendar endTime1 = Calendar.getInstance();
        endTime1.add(Calendar.MONTH, 1);
        BaseCalendarEvent event1 = new BaseCalendarEvent("Thibault travels in Iceland", "A wonderful journey!", "Iceland", ContextCompat.getColor(this, R.color.accent), startTime1, endTime1, true);
        eventList.add(event1);
        Calendar startTime2 = Calendar.getInstance();
        startTime2.add(Calendar.DAY_OF_YEAR, 1);
        Calendar endTime2 = Calendar.getInstance();
        endTime2.add(Calendar.DAY_OF_YEAR, 3);
        BaseCalendarEvent event2 = new BaseCalendarEvent("Visit to Dalvík", "A beautiful small town", "Dalvík", ContextCompat.getColor(this, R.color.blue_selected), startTime2, endTime2, true);
        eventList.add(event2); // Example on how to provide your own layout Calendar startTime3 = Calendar.getInstance(); Calendar endTime3 = Calendar.getInstance(); startTime3.set(Calendar.HOUR_OF_DAY, 14); startTime3.set(Calendar.MINUTE, 0); endTime3.set(Calendar.HOUR_OF_DAY, 15); endTime3.set(Calendar.MINUTE, 0); DrawableCalendarEvent event3 = new DrawableCalendarEvent("Visit of Harpa", "", "Dalvík", ContextCompat.getColor(this, R.color.blue_dark), startTime3, endTime3, false, R.drawable.common_ic_googleplayservices); eventList.add(event3); }
    }
        @Override
        void initData() {

        }

        @Override
        void initListener () {

        }

        @Override
        void processClick (View v){

        }

        @Override
        protected void BarRightClick () {

        }

    @Override
    public void onDaySelected(DayItem dayItem) {

    }

    @Override
    public void onEventSelected(CalendarEvent event) {

    }

    @Override
    public void onScrollToDate(Calendar calendar) {

    }
}

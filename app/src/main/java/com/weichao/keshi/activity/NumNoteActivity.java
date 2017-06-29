package com.weichao.keshi.activity;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.weichao.keshi.R;
import com.weichao.keshi.adapter.NumNoteAdapter;
import com.weichao.keshi.bean.NumNoteItem;

import java.util.ArrayList;

/**
 * @ 创建时间: 2017/5/24 on 10:13.
 * @ 描述：校园通讯录页面
 * @ 作者: 郑卫超 QQ: 2318723605
 */
public class NumNoteActivity extends BaseActivity {

    private RecyclerView rv_num_note;
    private ArrayList<NumNoteItem> data;
    String[] num_type = {"后勤","教务处","图书馆"
    };
    String[] num_name = {"赵老师","钱老师","孙老师"
    };
    String[] num_num = {"1111111111","222222222","33333333"
    };


    @Override
    int getLayoutId() {
        return R.layout.activity_num_note;
    }

    @Override
    Activity getmActivity() {
        return NumNoteActivity.this;
    }

    @Override
    void initView() {
        rv_num_note = (RecyclerView) findViewById(R.id.rv_num_note);
        rv_num_note.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    void initData() {
        data = new ArrayList<>();
        for (int i = 0; i < num_type.length; i++) {
            NumNoteItem numNoteItem = new NumNoteItem(num_num[i], num_name[i],num_type[i]);
            data.add(numNoteItem);
        }
        NumNoteAdapter numNoteAdapter = new NumNoteAdapter();
        numNoteAdapter.setData(data);

        rv_num_note.setAdapter(numNoteAdapter);

    }

    @Override
    void initListener() {

    }

    @Override
    void processClick(View v) {

    }

    @Override
    protected void BarRightClick() {

    }
}

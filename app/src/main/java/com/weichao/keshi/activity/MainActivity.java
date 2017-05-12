package com.weichao.keshi.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.weichao.keshi.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.rv_main);
//        mRecyclerView = findView(R.id.id_recyclerview);
        //设置布局管理器
        mRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,3));
       /* //设置adapter
        mRecyclerView.setAdapter(adapter)
        //设置Item增加、移除动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //添加分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(
                getActivity(), DividerItemDecoration.HORIZONTAL_LIST));*/

    }
}

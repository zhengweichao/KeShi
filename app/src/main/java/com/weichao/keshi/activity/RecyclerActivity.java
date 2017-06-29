package com.weichao.keshi.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import com.weichao.keshi.R;
import com.weichao.keshi.adapter.RecyclerAdapter;
import com.weichao.keshi.bean.ListBean;

import java.util.ArrayList;
import java.util.List;


/**
 * ListView替代者 RecyclerView的实现过程
 */
public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private List<ListBean> mStaggerData = new ArrayList<ListBean>();

    public int[] mStaggerIcons = new int[]{ R.mipmap.p44,R.mipmap.p1, R.mipmap.p2, R.mipmap.p3, R
            .mipmap.p4, R.mipmap.p5, R.mipmap.p6, R.mipmap.p7, R.mipmap.p8, R.mipmap.p9, R
            .mipmap.p10, R.mipmap.p11, R.mipmap.p12, R.mipmap.p13, R.mipmap.p14, R.mipmap
            .p15, R.mipmap.p16, R.mipmap.p17, R.mipmap.p18, R.mipmap.p19, R.mipmap.p20, R
            .mipmap.p21, R.mipmap.p22, R.mipmap.p23, R.mipmap.p24, R.mipmap.p25, R.mipmap
            .p26, R.mipmap.p27, R.mipmap.p28, R.mipmap.p29, R.mipmap.p30, R.mipmap.p31, R
            .mipmap.p32, R.mipmap.p33, R.mipmap.p34};
    /* R.mipmap.p35, R.mipmap.p36, R.mipmap
            .p37, R.mipmap.p38, R.mipmap.p39, R.mipmap.p40, R.mipmap.p41, R.mipmap.p42, R
            .mipmap.p43,*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recycler);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        //初始化View
        initView();

        //设置数据
        initData();

        //设置适配器
        initStaggerAdapterV();

        initRefresh();

    }

    /**
     * 初始化View
     */
    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_my);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.spl_main);
    }

    /**
     * 模拟刷新过程
     */
    private void initRefresh() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SystemClock.sleep(2000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //停止刷新操作
                                mSwipeRefreshLayout.setRefreshing(false);
                                //得到adapter.然后刷新
                                mRecyclerView.getAdapter().notifyDataSetChanged();
                            }
                        });
                    }
                }).start();
            }
        });
    }

    /**
     * 模拟列表数据
     */
    private void initData() {
        for (int i = 0; i < mStaggerIcons.length; i++) {
            ListBean listBean = new ListBean();
            listBean.setIconId(mStaggerIcons[i])  ;
            listBean.setName( "item - " + i);
            mStaggerData.add(listBean);
        }
    }

    /**
     * 设置纵向瀑布流
     */
    private void initStaggerAdapterV() {
        //设置layoutManager
        StaggeredGridLayoutManager layoutManger = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManger);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(RecyclerActivity.this, mStaggerData);
        recyclerAdapter.setOnItemClickLitener(new RecyclerAdapter.OnItemClickLitener() {
            // TODO: 2017/4/16 点击事件,传递对象
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(RecyclerActivity.this,PicDetailActivity.class);
                intent.putExtra("position",position);
//                intent.putExtra("aa",(Serializable) mStaggerData);
                intent.putExtra("id",mStaggerData.get(position).getIconId());
                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(RecyclerActivity.this, view, "shareView").toBundle();
                startActivity(intent,bundle);
                Log.i("zwc", "onItemClick: "+position);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Log.i("zwc", "onItemLongClick: 222222222222222"+position);
            }
        });

        mRecyclerView.setAdapter(recyclerAdapter);
    }


}

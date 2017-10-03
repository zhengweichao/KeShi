package com.weichao.keshi.cootab;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weichao.keshi.R;
import com.weichao.keshi.activity.NewsWebActivity;
import com.weichao.keshi.adapter.NNNAdapter;
import com.weichao.keshi.bean.NewsBean;
import com.weichao.keshi.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import xyz.zpayh.adapter.IMultiItem;
import xyz.zpayh.adapter.OnItemClickListener;

/**
 * Created by hugeterry(http://hugeterry.cn)
 * Date: 17/1/28 17:36
 */
public class MainFragment2 extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;

    private List<String> mDatas;
    private static final String ARG_TITLE = "title";
    private String mTitle;
    private NNNAdapter nnnAdapter;
    private ArrayList<NewsBean> newsBeen;

    public static MainFragment2 getInstance(String title) {
        MainFragment2 fra = new MainFragment2();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITLE, title);
        fra.setArguments(bundle);
        return fra;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        mTitle = bundle.getString(ARG_TITLE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
        initData();
        return v;
    }

    protected void initData() {
        nnnAdapter = new NNNAdapter();
        newsBeen = new ArrayList<>();
        BmobQuery<NewsBean> query = new BmobQuery<NewsBean>();
        query.order("-time");
        //返回6条数据，如果不加上这条语句，默认返回10条数据
        query.setLimit(10);
        query.addWhereEqualTo("kind","a");
        // 希望在查询帖子信息的同时也把发布人的信息查询出来
        query.include("author");
        //执行查询方法
        query.findObjects(new FindListener<NewsBean>() {
            @Override
            public void done(List<NewsBean> object, BmobException e) {
                if (e == null) {
                    LogUtils.e("查询成功：共" + object.size() + "条数据。");
                    for (NewsBean priceItem : object) {
                        newsBeen.add(priceItem);
                    }
                    nnnAdapter.setData(newsBeen);
                } else {
                    LogUtils.e("失败：" + e.getMessage() + "," + e.getErrorCode());
                }
            }
        });

        mRecyclerView.setAdapter(nnnAdapter);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListener();
    }

    private void initListener() {
        nnnAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull View view, int position) {
                LogUtils.e(newsBeen.get(position).getContent());
                Intent intent = new Intent(getActivity(), NewsWebActivity.class);
                intent.putExtra("url", newsBeen.get(position).getContent());
                startActivity(intent);
            }
        });
    }
}
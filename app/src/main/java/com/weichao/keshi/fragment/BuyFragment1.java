package com.weichao.keshi.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weichao.keshi.R;
import com.weichao.keshi.activity.BuyDetailActivity;
import com.weichao.keshi.adapter.NNNAdapter;
import com.weichao.keshi.bean.SaleItem;
import com.weichao.keshi.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import xyz.zpayh.adapter.OnItemClickListener;

/**
 * 二手交易 - 卖
 */
public class BuyFragment1 extends Fragment {
    private RecyclerView mRecyclerView;

    private static final String ARG_TITLE = "title";
    private String mTitle;
    private NNNAdapter mAdapter;
    private ArrayList<SaleItem> saleBeen;

    public static BuyFragment1 getInstance(String title) {
        BuyFragment1 fra = new BuyFragment1();
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
        mAdapter = new NNNAdapter();
        saleBeen = new ArrayList<>();

        BmobQuery<SaleItem> query = new BmobQuery<SaleItem>();
        query.order("-createdAt");
        //返回6条数据，如果不加上这条语句，默认返回10条数据
        query.setLimit(15);
        //执行查询方法
        query.findObjects(new FindListener<SaleItem>() {
            @Override
            public void done(List<SaleItem> object, BmobException e) {
                if (e == null) {
                    LogUtils.e("查询成功：共" + object.size() + "条数据。");
                    for (SaleItem loseItem : object) {
                        saleBeen.add(loseItem);
                        LogUtils.e(loseItem.getAuthor());
                    }
                    mAdapter.setData(saleBeen);
                } else {
                    LogUtils.e("失败：" + e.getMessage() + "," + e.getErrorCode());
                }
            }
        });

        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListener();
    }

    private void initListener() {
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull View view, int position) {
                Intent intent = new Intent(getActivity(), BuyDetailActivity.class);
                intent.putExtra("salebean", saleBeen.get(position));
                startActivity(intent);
            }
        });
    }

}
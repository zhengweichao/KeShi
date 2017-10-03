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
import com.weichao.keshi.activity.LoseDetailActivity;
import com.weichao.keshi.activity.NewsWebActivity;
import com.weichao.keshi.adapter.NNNAdapter;
import com.weichao.keshi.bean.LoseItem;
import com.weichao.keshi.cootab.RecyclerAdapter;
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
public class LoseFragment1 extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;

    private List<String> mDatas;
    private static final String ARG_TITLE = "title";
    private String mTitle;
    private NNNAdapter LoseAdapter;
    private ArrayList<LoseItem> LoseBeen;

    public static LoseFragment1 getInstance(String title) {
        LoseFragment1 fra = new LoseFragment1();
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
        LoseAdapter = new NNNAdapter();
        LoseBeen = new ArrayList<>();

        BmobQuery<LoseItem> query = new BmobQuery<LoseItem>();
        query.order("-time");
        //返回6条数据，如果不加上这条语句，默认返回10条数据
        query.setLimit(15);
        //执行查询方法
        query.findObjects(new FindListener<LoseItem>() {
            @Override
            public void done(List<LoseItem> object, BmobException e) {
                if (e == null) {
                    LogUtils.e("查询成功：共" + object.size() + "条数据。");
                    for (LoseItem loseItem : object) {
                        LoseBeen.add(loseItem);
                        LogUtils.e(loseItem.getAuthor());
                    }
                    LoseAdapter.setData(LoseBeen);
                } else {
                    LogUtils.e("失败：" + e.getMessage() + "," + e.getErrorCode());
                }
            }
        });

        mRecyclerView.setAdapter(LoseAdapter);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListener();
    }

    private void initListener() {
        LoseAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull View view, int position) {
                Intent intent = new Intent(getActivity(), LoseDetailActivity.class);
                intent.putExtra("losebean",LoseBeen.get(position));
                startActivity(intent);
            }
        });
    }

}
package com.weichao.keshi.cootab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weichao.keshi.R;
import com.weichao.keshi.adapter.NNNAdapter;
import com.weichao.keshi.bean.NewsBean1;
import com.weichao.keshi.bean.NewsBean2;
import com.weichao.keshi.bean.NewsBean3;

import java.util.ArrayList;
import java.util.List;

import xyz.zpayh.adapter.IMultiItem;

/**
 * Created by hugeterry(http://hugeterry.cn)
 * Date: 17/1/28 17:36
 */
public class MainFragment3 extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;

    private List<String> mDatas;
    private static final String ARG_TITLE = "title";
    private String mTitle;

    public static MainFragment3 getInstance(String title) {
        MainFragment3 fra = new MainFragment3();
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
        NNNAdapter nnnAdapter = new NNNAdapter();
        ArrayList<IMultiItem> newsBeen = new ArrayList<>();
        NewsBean1 newsBean1 = new NewsBean1("习近平：坚持走中国特色社会主义社会治理之路", "新华社", "09-19");
        NewsBean2 newsBean2 = new NewsBean2("习近平：坚持走中国特色社会主义社会治理之路", "新华社", "09-19", "2");
        NewsBean3 newsBean3 = new NewsBean3("习近平：坚持走中国特色社会主义社会治理之路", "新华社", "09-19", "3", "", "");

        newsBeen.add(newsBean1);
        newsBeen.add(newsBean2);
        newsBeen.add(newsBean3);

        newsBeen.add(newsBean1);
        newsBeen.add(newsBean2);
        newsBeen.add(newsBean3);

        nnnAdapter.setData(newsBeen);

        mRecyclerView.setAdapter(nnnAdapter);
    }

}
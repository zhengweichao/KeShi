package com.weichao.keshi.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.weichao.keshi.CONFIG;
import com.weichao.keshi.R;
import com.weichao.keshi.adapter.NNNAdapter;
import com.weichao.keshi.adapter.NewsAdapter;
import com.weichao.keshi.adapter.TextListAdapter;
import com.weichao.keshi.bean.NewsBean;
import com.weichao.keshi.bean.NewsBean1;
import com.weichao.keshi.bean.NewsBean2;
import com.weichao.keshi.bean.NewsBean3;

import java.util.ArrayList;

import xyz.zpayh.adapter.IMultiItem;

/**
 * Created by 郑卫超 on 2017/5/3.
 * Email: Matthew_Chen_1994@163.com
 * Blog: https://blog.ifmvo.cn
 */

public class TabFragment2 extends BaseFragment {
    private RecyclerView mRvTextList;

    @Override
    protected View initView() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_tab, null);
        mRvTextList= (RecyclerView)inflate.findViewById(R.id.rv_text_list);
        mRvTextList.setLayoutManager(new LinearLayoutManager(mActivity,LinearLayoutManager.VERTICAL,false));

        return inflate;
    }

    @Override
    public void initData() {
        NNNAdapter nnnAdapter = new NNNAdapter();
        ArrayList<IMultiItem> newsBeen = new ArrayList<>();
        NewsBean1 newsBean1 = new NewsBean1("习近平：坚持走中国特色社会主义社会治理之路", "新华社", "09-19");
        NewsBean2 newsBean2 = new NewsBean2("习近平：坚持走中国特色社会主义社会治理之路", "新华社", "09-19","2");
        NewsBean3 newsBean3 = new NewsBean3("习近平：坚持走中国特色社会主义社会治理之路", "新华社", "09-19","3","","");

        newsBeen.add(newsBean1);
        newsBeen.add(newsBean2);
        newsBeen.add(newsBean3);

        newsBeen.add(newsBean1);
        newsBeen.add(newsBean2);
        newsBeen.add(newsBean3);

        nnnAdapter.setData(newsBeen);

        mRvTextList.setAdapter(nnnAdapter);
    }

    @Override
    public void initListener() {

    }

}

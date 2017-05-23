package com.weichao.keshi.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weichao.keshi.R;


/**
 * @ 创建时间: 2017/4/26 on 22:36.
 * @ 描述：
 * @ 作者: 郑卫超 QQ: 2318723605
 */

public class CooFra extends Fragment {

    private static final String ARG_TITLE = "title";

    public static CooFra getInstance(String title) {
        CooFra fra = new CooFra();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITLE, title);
        fra.setArguments(bundle);
        return fra;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_blank, container, false);

//        mRecyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
//        mRecyclerView.setAdapter(mAdapter = new CooRecyclerAdapter(mRecyclerView.getContext(), mDatas));

        return v;
    }

}

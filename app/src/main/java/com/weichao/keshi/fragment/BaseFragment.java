package com.weichao.keshi.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * @ 创建时间: 2017/5/14 on 14:20.
 * @ 描述：BaseFragment 基类
 * @ 作者: 郑卫超 QQ: 2318723605
 */
public abstract class BaseFragment extends Fragment {

    public FragmentActivity mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
    }

    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = initView();
        ButterKnife.bind(this, view);
        return view;
    }

    //view的初始化
    protected abstract View initView();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initListener();
    }

    /**
     * 初始化数据
     */
    public abstract void initData();

    /**
     * 初始化监听器
     */
    public abstract void initListener();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}

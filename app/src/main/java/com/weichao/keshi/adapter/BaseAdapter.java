package com.weichao.keshi.adapter;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import xyz.zpayh.adapter.BaseViewHolder;

/**
 * @ 创建时间: 2017/5/12 on 20:41.
 * @ 描述：
 * @ 作者: 郑卫超 QQ: 2318723605
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder>{

    /**
     * 返回布局layout
     */
    @LayoutRes
    public abstract int getLayoutRes(int index);

    /**
     * 在这里设置显示
     */
    public abstract void convert(BaseViewHolder holder, T data, int index);

    /**
     * 开启子view的点击事件，或者其他监听
     */
    public abstract void bind(BaseViewHolder holder,int layoutRes);
}

package com.weichao.keshi.adapter;

import com.weichao.keshi.R;
import com.weichao.keshi.bean.MoudleItem;

import xyz.zpayh.adapter.BaseAdapter;
import xyz.zpayh.adapter.BaseViewHolder;

/**
 * @ 创建时间: 2017/5/17 on 13:09.
 * @ 描述：首页模块条目适配器
 * @ 作者: 郑卫超 QQ: 2318723605
 */
public class MoudleAdapter extends BaseAdapter<MoudleItem> {

    @Override
    public int getLayoutRes(int index) {
        return R.layout.item_list;
    }

    @Override
    public void convert(BaseViewHolder holder, MoudleItem data, int index) {
        holder.setText(R.id.tv_item_name,data.getmImageTitle());
        holder.setImage(R.id.iv_item_logo,data.getmImageResId());
    }

    @Override
    public void bind(BaseViewHolder holder, int layoutRes) {

    }
}

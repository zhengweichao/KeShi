package com.weichao.keshi.adapter;

import com.weichao.keshi.R;
import com.weichao.keshi.bean.MoudleItem;
import com.weichao.keshi.bean.NumNoteItem;

import xyz.zpayh.adapter.BaseAdapter;
import xyz.zpayh.adapter.BaseViewHolder;

/**
 * @ 创建时间: 2017/5/24 on 10:31.
 * @ 描述：通讯录适配器
 * @ 作者: 郑卫超 QQ: 2318723605
 */

public class NumNoteAdapter extends BaseAdapter<NumNoteItem> {

    @Override
    public int getLayoutRes(int index) {
        return R.layout.item_num_note;
    }

    @Override
    public void convert(BaseViewHolder holder, NumNoteItem data, int index) {
        holder.setText(R.id.tv_num_name,data.getName());
        holder.setText(R.id.tv_num_type,data.getType());
        holder.setText(R.id.tv_num_num,data.getNum());
    }

    @Override
    public void bind(BaseViewHolder holder, int layoutRes) {

    }
}

package com.weichao.keshi.adapter;

import com.weichao.keshi.R;
import com.weichao.keshi.bean.MoudleItem;
import com.weichao.keshi.bean.WebGuideItem;

import xyz.zpayh.adapter.BaseAdapter;
import xyz.zpayh.adapter.BaseViewHolder;

/**
 * @ 创建时间: 2017/5/13 on 13:09.
 * @ 描述：
 * @ 作者: 郑卫超 QQ: 2318723605
 */

public class WebGuideAdapter extends BaseAdapter<WebGuideItem> {

    @Override
    public int getLayoutRes(int index) {
        return R.layout.item_guide_web;
    }

    @Override
    public void convert(BaseViewHolder holder, WebGuideItem data, int index) {
        holder.setText(R.id.tv_webitem_name,data.getmImageTitle());
        holder.setImage(R.id.iv_webitem_logo,data.getmImageResId());
    }

    @Override
    public void bind(BaseViewHolder holder, int layoutRes) {

    }
}

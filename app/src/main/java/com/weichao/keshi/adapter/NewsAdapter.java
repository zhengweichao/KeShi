package com.weichao.keshi.adapter;

import com.weichao.keshi.R;
import com.weichao.keshi.bean.MoudleItem;
import com.weichao.keshi.bean.NewsBean;
import com.weichao.keshi.utils.LogUtils;

import xyz.zpayh.adapter.BaseAdapter;
import xyz.zpayh.adapter.BaseViewHolder;

/**
 * @ 创建时间: 2017/9/19 on 23:14.
 * @ 描述：
 * @ 作者: 郑卫超 QQ: 2318723605
 */

public class NewsAdapter extends BaseAdapter<NewsBean> {

    private String tag;

    @Override
    public int getLayoutRes(int index) {
//        LogUtils.e("ggggggggggggggggg");
        if ("1".equals(tag)) {
            LogUtils.e("1111111111");
            return R.layout.item_news_type1;
        } else if ("2".equals(tag)) {
            LogUtils.e("222222222");
            return R.layout.item_news_type2;
        } else {
            LogUtils.e("333333333");
            return R.layout.item_news_type3;
        }
    }

    @Override
    public void convert(BaseViewHolder holder, NewsBean data, int index) {
        LogUtils.e("cccccccccccccc");
        tag = data.getTag();

        if ("1".equals(tag)) {
            holder.setText(R.id.tv_type1_title, data.getTitle());
            holder.setText(R.id.tv_type1_time, data.getTime());
            holder.setText(R.id.tv_type1_author, data.getAuthor());
        }else if ("2".equals(tag)) {
            holder.setText(R.id.tv_type1_title, data.getTitle());
            holder.setText(R.id.tv_type1_time, data.getTime());
            holder.setText(R.id.tv_type1_author, data.getAuthor());
        }else{
            holder.setText(R.id.tv_type1_title, data.getTitle());
            holder.setText(R.id.tv_type1_time, data.getTime());
            holder.setText(R.id.tv_type1_author, data.getAuthor());
        }


    }

    @Override
    public void bind(BaseViewHolder holder, int layoutRes) {

    }
}

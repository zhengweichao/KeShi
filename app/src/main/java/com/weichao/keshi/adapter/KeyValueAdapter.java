package com.weichao.keshi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.weichao.keshi.R;
import com.weichao.keshi.bean.KeyValue;

import java.util.List;

/**
 * 创建日期:2016/12/15 on 15:51
 * 描述:
 * 作者:郭士超
 * English name:Super丶C
 * QQ:1169380200
 */

public class KeyValueAdapter extends BaseAdapter {

    private List<KeyValue> keyValueList;
    private Context context;

    public KeyValueAdapter(Context context, List<KeyValue> keyValueList) {
        this.keyValueList = keyValueList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return keyValueList.size();
    }

    @Override
    public KeyValue getItem(int i) {
        return keyValueList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view;
        view = (LinearLayout) inflater.inflate(R.layout.layout_list_item_option, null);

        TextView tvProperty = (TextView) view.findViewById(R.id.tvProperty);
        TextView tvValue = (TextView) view.findViewById(R.id.tvValue);

        tvProperty.setText(keyValueList.get(i).getKey());
        tvValue.setText(keyValueList.get(i).getValueStr());

        return view;
    }

}
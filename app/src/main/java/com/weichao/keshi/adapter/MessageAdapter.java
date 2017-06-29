package com.weichao.keshi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.weichao.keshi.R;
import com.weichao.keshi.bean.Message;

import java.util.List;

/**
 * 创建日期:2017/5/25 on 0:17
 * 描述: 消息列表适配器
 * 作者:郑卫超
 * QQ:1169380200
 */

public class MessageAdapter extends BaseAdapter {

    private List<Message> messageList;
    private Context context;
    private RelativeLayout layout;

    public MessageAdapter(List<Message> messageList, Context context) {

        this.messageList = messageList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return messageList.size();
    }

    @Override
    public Object getItem(int position) {
        return messageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if (messageList.get(position).getFlag() == Message.RECEIVER) {
            layout = (RelativeLayout) inflater.inflate(R.layout.layout_list_item_message_left, null);
        }
        if (messageList.get(position).getFlag() == Message.SEND) {
            layout = (RelativeLayout) inflater.inflate(R.layout.layout_list_item_message_rigth, null);
        }

        TextView tvMessageTime = (TextView) layout.findViewById(R.id.tvMessageTime);
        if (!"".equals(messageList.get(position).getTime())) {
            tvMessageTime.setText(messageList.get(position).getTime());
        } else {
            tvMessageTime.setVisibility(View.GONE);
        }

        TextView tvMessage = (TextView) layout.findViewById(R.id.tvMessage);
        tvMessage.setText(messageList.get(position).getContent());
        return layout;
    }

}
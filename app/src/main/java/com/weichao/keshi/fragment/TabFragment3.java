package com.weichao.keshi.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.weichao.keshi.R;
import com.weichao.keshi.activity.AtySetting;
import com.weichao.keshi.activity.StudentActivity;
import com.weichao.keshi.adapter.KeyValueAdapter;
import com.weichao.keshi.bean.KeyValue;
import com.weichao.keshi.bean.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @ 创建时间: 2017/5/21 on 19:39.
 * @ 描述：我的页面fragment
 * @ 作者: 郑卫超 QQ: 2318723605
 */

public class TabFragment3 extends BaseFragment {

    private List<KeyValue> kvScreenList = new ArrayList<KeyValue>();
    private KeyValueAdapter adapterScreen;
    private ListView lvScreen;
    private List<KeyValue> kvOtherList = new ArrayList<KeyValue>();
    private KeyValueAdapter adapterOther;
    private ListView lvOther;

    @Override
    protected View initView() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.aty_setting, null);
        adapterScreen = new KeyValueAdapter(mActivity, kvScreenList);
        lvScreen = (ListView) inflate.findViewById(R.id.lvScreen);
        lvScreen.setAdapter(adapterScreen);

        adapterOther = new KeyValueAdapter(mActivity, kvOtherList);
        lvOther = (ListView) inflate.findViewById(R.id.lvOther);
        lvOther.setAdapter(adapterOther);

        return inflate;
    }

    @Override
    public void initData() {
        initScreen();//加载屏幕显示
        initOther();
    }


    @Override
    public void initListener() {
//        菜单监听事件
        lvOther.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    // TODO: 2017/6/26 退出登录
                    case 0:

                        mActivity.finish();
                        break;
                    // TODO: 2017/6/26 菜单二
                    case 1:
                        break;

                    // TODO: 2017/6/26  菜单三
                    case 2:
                        break;
                }
            }
        });
//
        lvScreen.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i;
                switch (position) {
//                    菜单一:学生信息查询
                    case 0:
                        Intent intent = new Intent(mActivity, StudentActivity.class);
                        startActivity(intent);
                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                }
            }
        });
    }

    private void initScreen() {
        kvScreenList.clear();
        KeyValue f = new KeyValue("学生信息查询", "");
        kvScreenList.add(f);
        KeyValue s = new KeyValue("菜单二", "");
        kvScreenList.add(s);
        KeyValue c = new KeyValue("菜单三", "");
        kvScreenList.add(c);
    }

    private void initOther() {
        kvOtherList.clear();
        KeyValue kv0 = new KeyValue("退出登录", "");
        kvOtherList.add(kv0);
        KeyValue kv1 = new KeyValue("检查更新", "");
        kvOtherList.add(kv1);
        KeyValue kv2 = new KeyValue("关于", "");
        kvOtherList.add(kv2);

        adapterOther.notifyDataSetChanged();
    }
}

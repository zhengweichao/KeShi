package com.weichao.keshi.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.weichao.keshi.R;
import com.weichao.keshi.adapter.ContactAdapter;
import com.weichao.keshi.bean.ContactBean;
import com.weichao.keshi.utils.CommonUtil;
import com.weichao.keshi.view.CustomItemDecoration;
import com.weichao.keshi.view.SideBar;

import java.util.ArrayList;
import java.util.List;

import it.gmariotti.recyclerview.itemanimator.SlideInOutLeftItemAnimator;

/**
 * 联系人页面
 */
public class ContactsActivity extends BaseActivity {

    private RecyclerView rl_recycle_view;
    private ContactAdapter mAdapter;
    private CustomItemDecoration decoration;
    private SideBar side_bar;
    List<ContactBean> nameList = new ArrayList<>();
    private LinearLayoutManager layoutManager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_contacts;
    }

    @Override
    public void initView() {
        initTitleBar(R.color.colorPrimary, R.string.contacts);

        mAdapter = new ContactAdapter(this);
        rl_recycle_view = (RecyclerView) findViewById(R.id.rl_recycle_view);
        //侧边导航栏
        side_bar = (SideBar) findViewById(R.id.side_bar);
        layoutManager = new LinearLayoutManager(this);
        rl_recycle_view.setLayoutManager(layoutManager);
        rl_recycle_view.addItemDecoration(decoration = new CustomItemDecoration(this));
        rl_recycle_view.setItemAnimator(new SlideInOutLeftItemAnimator(rl_recycle_view));
    }

    public void add() {
        ContactBean bean = new ContactBean();
        bean.setName("安其拉666");
        nameList.add(bean);
        //对数据源进行排序
        CommonUtil.sortData(nameList);
        //返回一个包含所有Tag字母在内的字符串并赋值给tagsStr
        String tagsStr = CommonUtil.getTags(nameList);
        side_bar.setIndexStr(tagsStr);
        decoration.setDatas(nameList, tagsStr);
        //这里写死位置1 只是为了看动画效果
        mAdapter.add(bean, 1);
    }

    @Override
    void initData() {
        String[] names = {
                "数信院-韩坤-老师", "数信院-张志广-老师", "数信院-王奭-老师", "党宣部-李竹韵-老师",
                "图书馆-王春兰-老师", "图书馆-赵跃-老师", "校团委-于箭-老师", "后勤水电-王师傅",
                "物理系-张步英-老师", "物理系-张金旭-老师", "物理系-郑丽洁-老师", "招生办-孙志杨-老师",
                "财经院-高士坤-老师", "工商-曹佳-老师", "体育系-孙颖-老师", "教务处-钱佳颖-老师",
                "体育系-王成纲-老师", "财经-高凤云-老师", "学生处-赵冀霞-老师","宿管-李丽红-阿姨"};
        String[] tels = {
                "13930386897", "18833522955", "13333330910", "13932074255",
                "13930023254", "15033551108", "13780478042", "13932074255",
                "13930023254", "15033551108", "13780478042", "13932074255",
                "13930023254", "15033551108", "13780478042", "13932074255",
                "13930023254", "15033551108", "13780478042", "13932074255",};

        for (int i = 0; i <names.length ; i++) {
            ContactBean bean = new ContactBean();
            bean.setName(names[i]);
            bean.setTel(tels[i]);
            nameList.add(bean);
        }

        //对数据源进行排序
        CommonUtil.sortData(nameList);
        //返回一个包含所有Tag字母在内的字符串并赋值给tagsStr
        String tagsStr = CommonUtil.getTags(nameList);
        side_bar.setIndexStr(tagsStr);
        decoration.setDatas(nameList, tagsStr);
        mAdapter.addAll(nameList);

        rl_recycle_view.setAdapter(mAdapter);
    }

    @Override
    void initListener() {
        side_bar.setIndexChangeListener(new SideBar.indexChangeListener() {
            @Override
            public void indexChanged(String tag) {
                if (TextUtils.isEmpty(tag) || nameList.size() <= 0) return;
                for (int i = 0; i < nameList.size(); i++) {
                    if (tag.equals(nameList.get(i).getIndexTag())) {
                        layoutManager.scrollToPositionWithOffset(i, 0);
//                        layoutManager.scrollToPosition(i);
                        return;
                    }
                }
            }
        });
//        点击事件
        mAdapter.setOnItemClickListener(new ContactAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //跳到拨号页面
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + nameList.get(position).getTel()));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }

}

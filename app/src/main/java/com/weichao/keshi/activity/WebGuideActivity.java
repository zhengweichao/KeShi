package com.weichao.keshi.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.weichao.keshi.R;
import com.weichao.keshi.adapter.WebGuideAdapter;
import com.weichao.keshi.bean.WebGuideItem;

import java.util.ArrayList;

import xyz.zpayh.adapter.OnItemClickListener;

public class WebGuideActivity extends BaseActivity {

    private RecyclerView rv_web_guide;

    @Override
    int getLayoutId() {
        return R.layout.activity_guide;
    }

    @Override
    Activity getmActivity() {
        return WebGuideActivity.this;
    }

    @Override
    void initView() {
        String[] WebTitleName = {"学校官网","教务处","图书馆",
                "贴吧","街景"
        };
        int[] WebLogo={R.mipmap.ic_keshi,R.mipmap.buysale,R.mipmap.ic_library,
            R.mipmap.news,R.mipmap.news
        };

        String[] urls={"http://www.hevttc.edu.cn/",
                "http://www.hevttc.edu.cn/",
                "http://w3.hevttc.edu.cn/tsg/",
                "http://tieba.baidu.com/f?kw=%E6%B2%B3%E5%8C%97%E7%A7%91%E6%8A%80%E5%B8%88%E8%8C%83%E5%AD%A6%E9%99%A2",
                "http://map.qq.com/#pano=11031132130703102635000&heading=327&pitch=11&zoom=1"
        };

        rv_web_guide = (RecyclerView) findViewById(R.id.rv_web_guide);
        rv_web_guide.setLayoutManager(new GridLayoutManager(this,3));
        final ArrayList<WebGuideItem> data = new ArrayList<>();
        for (int i = 0; i < WebTitleName.length; i++) {
            WebGuideItem webGuideItem = new WebGuideItem(WebLogo[i], WebTitleName[i], urls[i]);
            data.add(webGuideItem);
        }
        WebGuideAdapter webGuideAdapter = new WebGuideAdapter();
        webGuideAdapter.setData(data);
        webGuideAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull View view, int adapterPosition) {
                Toast.makeText(WebGuideActivity.this, "aaaaa"+adapterPosition, Toast.LENGTH_SHORT).show();
                WebGuideItem item =data.get(adapterPosition);
                //跳转到对应功能的详情页面
                String url = item.getUrl();
                Intent intent =new  Intent(WebGuideActivity.this,WebActivity.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });
        rv_web_guide.setAdapter(webGuideAdapter);
    }

    @Override
    void initData() {

    }

    @Override
    void initListener() {

    }

    @Override
    void processClick(View v) {

    }

    @Override
    protected void BarRightClick() {

    }
}
package com.weichao.keshi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import com.weichao.keshi.R;
import com.weichao.keshi.adapter.MoudleAdapter;
import com.weichao.keshi.bean.MoudleItem;
import java.util.ArrayList;
import xyz.zpayh.adapter.OnItemClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.rv_main);
        //设置布局管理器
        mRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,3));

        mRecyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this,DividerItemDecoration.HORIZONTAL));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this,DividerItemDecoration.VERTICAL));

        String[] MoudleName = {"失物招领","二手交易","表白墙",
                "校园新闻","通知公告","校历",
                "网址导航","校园通讯录","兴趣圈"
        };
        int[] MoudleLogo={R.mipmap.girl,R.mipmap.ic_launcher,R.mipmap.girl,
                R.mipmap.ic_launcher,R.mipmap.girl,R.mipmap.ic_launcher,
                R.mipmap.girl,R.mipmap.ic_launcher,R.mipmap.girl};
        Class[] clazz={LoseFindActivity.class,WebGuideActivity.class,LoseFindActivity.class,
                CooTabActivity.class,LoseFindActivity.class,LoseFindActivity.class,
                LoseFindActivity.class,LoseFindActivity.class,LoseFindActivity.class,
        };

        final ArrayList<MoudleItem> data = new ArrayList<>();
            for (int i = 0; i < MoudleName.length; i++) {
                MoudleItem moudleItem = new MoudleItem(MoudleLogo[i], MoudleName[i],clazz[i]);
                data.add(moudleItem);
            }
        MoudleAdapter moudleAdapter = new MoudleAdapter();
        moudleAdapter.setData(data);

        moudleAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull View view, int adapterPosition) {
                Toast.makeText(MainActivity.this, "aaaaa"+adapterPosition, Toast.LENGTH_SHORT).show();
                MoudleItem item = (MoudleItem) data.get(adapterPosition);
                //跳转到对应功能的详情页面
                Class clazz =item.getClazz();
                Intent intent = new Intent(MainActivity.this, clazz);
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(moudleAdapter);

    }

}

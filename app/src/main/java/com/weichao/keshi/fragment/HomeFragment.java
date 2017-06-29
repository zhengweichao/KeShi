package com.weichao.keshi.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.weichao.keshi.R;
import com.weichao.keshi.activity.AtyMessage;
import com.weichao.keshi.activity.AtySetting;
import com.weichao.keshi.activity.LoseFindActivity;
import com.weichao.keshi.activity.NumNoteActivity;
import com.weichao.keshi.activity.RecyclerActivity;
import com.weichao.keshi.activity.SchoolDateActivity;
import com.weichao.keshi.activity.StudentActivity;
import com.weichao.keshi.activity.WebGuideActivity;
import com.weichao.keshi.adapter.MoudleAdapter;
import com.weichao.keshi.bean.MoudleItem;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import xyz.zpayh.adapter.OnItemClickListener;

/**
 * @ 创建时间: 2017/5/21 on 19:39.
 * @ 描述：主页面fragment
 * @ 作者: 郑卫超 QQ: 2318723605
 */

public class HomeFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private Banner banner;
    private MoudleAdapter moudleAdapter;
    private ArrayList<MoudleItem> data;
    //轮播图图片资源
    Integer[] imageses={R.mipmap.keshi1,R.mipmap.keshi2,R.mipmap.keshi3,R.mipmap.keshi4};

    //模块名字
    String[] MoudleName = {"失物招领","二手交易","表白墙",
            "校园新闻","通知公告","校历",
            "网址导航","校园通讯录","兴趣圈"
    };
    //模块图片资源
    int[] MoudleLogo={R.mipmap.lose,R.mipmap.buysale,R.mipmap.loveshow,
            R.mipmap.news,R.mipmap.tellall,R.mipmap.schooldate,
            R.mipmap.schoolguide,R.mipmap.numbernote,R.mipmap.friends};
    //模块对应页面
    Class[] clazz={LoseFindActivity.class,WebGuideActivity.class,StudentActivity.class,
            RecyclerActivity.class,AtyMessage.class,SchoolDateActivity.class,
            WebGuideActivity.class,NumNoteActivity.class,LoseFindActivity.class,
    };

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected View initView() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.activity_main, null);
        //找控件
        mRecyclerView = (RecyclerView) inflate.findViewById(R.id.rv_main);
        banner = (Banner) inflate.findViewById(R.id.banner);
        //设置布局管理器
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        //添加分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.HORIZONTAL));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));

        return inflate;
    }

    @Override
    public void initData() {
        ArrayList images = new ArrayList<>();
        data = new ArrayList<>();
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //填充轮播图列表
        for (int i = 0; i < imageses.length ; i++) {
            images.add(imageses[i]);
        }
        banner.setDelayTime(3000);//设置轮播时间
        banner.setImages(images);//设置图片集合
        banner.start();//banner设置方法全部调用完毕时最后调用
        //填充模块信息列表
        for (int i = 0; i < MoudleName.length; i++) {
            MoudleItem moudleItem = new MoudleItem(MoudleLogo[i], MoudleName[i],clazz[i]);
            data.add(moudleItem);
        }
        moudleAdapter = new MoudleAdapter();
        moudleAdapter.setData(data);
        mRecyclerView.setAdapter(moudleAdapter);
    }

    @Override
    public void initListener() {
        moudleAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull View view, int adapterPosition) {
                MoudleItem item = data.get(adapterPosition);
                //跳转到对应功能的详情页面
                Intent intent = new Intent(getActivity(), item.getClazz());
                startActivity(intent);
            }
        });
    }

    /**
     * Glide图片加载方法
     */
    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            //Glide 加载图片
            Glide.with(context).load(path).into(imageView);
        }
    }
}

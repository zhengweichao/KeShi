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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.weichao.keshi.R;
import com.weichao.keshi.activity.LoseFindActivity;
import com.weichao.keshi.activity.WebGuideActivity;
import com.weichao.keshi.adapter.MoudleAdapter;
import com.weichao.keshi.bean.MoudleItem;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import xyz.zpayh.adapter.OnItemClickListener;

/**
 * Created by 郑卫超 on 2017/5/23.
 */

public class HomeFragment extends BaseFragment {

    Integer[] imageses={R.mipmap.bg_ios,R.mipmap.bg_android,R.mipmap.bg_other};

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected View initView() {

        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.activity_main, null);

        Banner banner = (Banner) inflate.findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        ArrayList images = new ArrayList<>();
        for (int i = 0; i < imageses.length ; i++) {
            images.add(imageses[i]);
        }
        //设置轮播时间
        banner.setDelayTime(2500);
//        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();

        RecyclerView mRecyclerView = (RecyclerView) inflate.findViewById(R.id.rv_main);
        //设置布局管理器
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));

        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.HORIZONTAL));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));

        String[] MoudleName = {"失物招领","二手交易","表白墙",
                "校园新闻","通知公告","校历",
                "网址导航","校园通讯录","兴趣圈"
        };
        int[] MoudleLogo={R.mipmap.lose,R.mipmap.buysale,R.mipmap.loveshow,
                R.mipmap.news,R.mipmap.tellall,R.mipmap.schooldate,
                R.mipmap.schoolguide,R.mipmap.numbernote,R.mipmap.friends};
        Class[] clazz={LoseFindActivity.class,WebGuideActivity.class,LoseFindActivity.class,
                LoseFindActivity.class,LoseFindActivity.class,LoseFindActivity.class,
                WebGuideActivity.class,LoseFindActivity.class,LoseFindActivity.class,
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
                Toast.makeText(getActivity(), "aaaaa"+adapterPosition, Toast.LENGTH_SHORT).show();
                MoudleItem item = (MoudleItem) data.get(adapterPosition);
                //跳转到对应功能的详情页面
                Class clazz =item.getClazz();
                Intent intent = new Intent(getActivity(), clazz);
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(moudleAdapter);

        return inflate;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            /**
             注意：
             1.图片加载器由自己选择，这里不限制，只是提供几种使用方法
             2.返回的图片路径为Object类型，由于不能确定你到底使用的那种图片加载器，
             传输的到的是什么格式，那么这种就使用Object接收和返回，你只需要强转成你传输的类型就行，
             切记不要胡乱强转！
             */

            //Glide 加载图片简单用法
            Glide.with(context).load(path).into(imageView);

        }


    }
}

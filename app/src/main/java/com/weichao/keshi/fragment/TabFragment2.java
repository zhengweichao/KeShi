package com.weichao.keshi.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.weichao.keshi.CONFIG;
import com.weichao.keshi.R;
import com.weichao.keshi.adapter.TextListAdapter;

/**
 * Created by 郑卫超 on 2017/5/3.
 * Email: Matthew_Chen_1994@163.com
 * Blog: https://blog.ifmvo.cn
 */

public class TabFragment2 extends BaseFragment {
    private RecyclerView mRvTextList;

    @Override
    protected View initView() {

        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_tab, null);
        mRvTextList= (RecyclerView)inflate.findViewById(R.id.rv_text_list);
        mRvTextList.setLayoutManager(new LinearLayoutManager(mActivity,LinearLayoutManager.VERTICAL,false));
        mRvTextList.setAdapter(new TextListAdapter(mActivity));
        return inflate;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }
    private void getDataFromNet() {
        //接口
        final String url= CONFIG.NEWSCENTER_URL;
//        okhttp
        /**
         * 6.0之后的sdk版本需要手动的添加org.apache.http.legacy.jar包
         * sdk路径\platforms\android-23\optional
         */

        /*HttpUtils httpUtils = new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.GET, url, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String result = responseInfo.result;
                Log.i("huida","成功："+result);

                //解析数据
                parseData(result);

                //将数据缓存到本地
                SpUtil.putString(url,result,mActivity);

            }

            @Override
            public void onFailure(HttpException error, String msg) {
                Log.i("huida","失败："+msg);
            }
        });*/

    }

}

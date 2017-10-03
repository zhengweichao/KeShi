package com.weichao.keshi.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.weichao.keshi.R;
import com.weichao.keshi.adapter.NNNAdapter;
import com.weichao.keshi.bean.TeamBean;
import com.weichao.keshi.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class TeamActivity extends BaseActivity {

    @Bind(R.id.rv_team)
    RecyclerView rvTeam;
    private NNNAdapter mAdapter;
    private ArrayList<TeamBean> teamBeen;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_team;
    }

    @Override
    void initView() {


    }

    @Override
    void initData() {
        mAdapter = new NNNAdapter();
        teamBeen = new ArrayList<>();
        rvTeam.setLayoutManager(new LinearLayoutManager(TeamActivity.this));

        BmobQuery<TeamBean> query = new BmobQuery<TeamBean>();
        query.order("-time");
        query.setLimit(15);
        query.findObjects(new FindListener<TeamBean>() {
            @Override
            public void done(List<TeamBean> object, BmobException e) {
                if (e == null) {
                    LogUtils.e("查询成功：共" + object.size() + "条数据。");
                    for (TeamBean teamBean : object) {
                        teamBeen.add(teamBean);
                    }
                    mAdapter.setData(teamBeen);
                } else {
                    LogUtils.e("失败：" + e.getMessage() + "," + e.getErrorCode());
                }
            }
        });
        rvTeam.setAdapter(mAdapter);
    }

}

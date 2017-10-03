package com.weichao.keshi.activity;

import com.weichao.keshi.R;

import butterknife.OnClick;

public class PushOKActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_push_ok;
    }


    @OnClick(R.id.btn_ok_back)
    public void onViewClicked() {
        onBackPressed();
    }
}

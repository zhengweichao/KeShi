package com.weichao.keshi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.weichao.keshi.R;
import com.weichao.keshi.bean.Feedback;
import com.weichao.keshi.bean.MyUser;
import com.weichao.keshi.utils.LogUtils;
import com.weichao.keshi.utils.ToastUtil;
import com.weichao.keshi.view.LoadDialog;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class ComplaintsDetailActivity extends BaseActivity {

    @Bind(R.id.sp_comp_kind)
    Spinner spCompKind;
    @Bind(R.id.et_comp_content)
    EditText etCompContent;
    String kind = "食堂投诉";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_complaints_detail;
    }

    @Override
    void initData() {

    }

    @Override
    void initListener() {
        spCompKind.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] units = getResources().getStringArray(R.array.feedkinds);
                kind = units[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @OnClick(R.id.bt_comp_submit)
    public void onViewClicked() {


        String content = etCompContent.getText().toString().trim();

        if (TextUtils.isEmpty(content)) {
            ToastUtil.showShort(ComplaintsDetailActivity.this, "请填写反馈信息！");
        } else {
            LoadDialog.show(ComplaintsDetailActivity.this, "反馈中……");

            Feedback bean = new Feedback();
            MyUser user = BmobUser.getCurrentUser(MyUser.class);
            bean.setTheme(kind);
            bean.setContent(content);
            bean.setUser(user);
            bean.save(new SaveListener<String>() {
                @Override
                public void done(String objectId, BmobException e) {
                    if (e == null) {
                        ToastUtil.show(ComplaintsDetailActivity.this, "我们已经收到您的反馈！", Toast.LENGTH_SHORT);
                        LogUtils.e("已经收到您的反馈：" + objectId);
                        Intent intent = new Intent(ComplaintsDetailActivity.this, PushOKActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        ToastUtil.show(ComplaintsDetailActivity.this, "反馈失败，请检查网络后重试！", Toast.LENGTH_SHORT);
                        LogUtils.e("失败：" + e.getMessage() + "," + e.getErrorCode());
                    }

                    LoadDialog.dismiss(ComplaintsDetailActivity.this);
                }
            });

        }
    }
}

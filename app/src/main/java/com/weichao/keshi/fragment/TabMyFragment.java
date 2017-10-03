package com.weichao.keshi.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.weichao.keshi.R;
import com.weichao.keshi.activity.AboutActivity;
import com.weichao.keshi.activity.FeedbackActivity;
import com.weichao.keshi.activity.LoginActivity;
import com.weichao.keshi.activity.StudentActivity;
import com.weichao.keshi.activity.UserInfoActivity;
import com.weichao.keshi.bean.MyUser;

import butterknife.Bind;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;

/**
 * @ 创建时间: 2017/5/21 on 19:39.
 * @ 描述：我的页面fragment
 * @ 作者: 郑卫超 QQ: 2318723605
 */

public class TabMyFragment extends BaseFragment {

    @Bind(R.id.tv_info_username)
    TextView tvInfoUsername;
    @Bind(R.id.tv_info_state)
    TextView tvInfoState;

    @Override
    protected View initView() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_my, null);

        return inflate;
    }

    @Override
    public void initData() {
        MyUser user = BmobUser.getCurrentUser(MyUser.class);
        if (!TextUtils.isEmpty(user.getUsername())) {
            tvInfoUsername.setText(user.getUsername());
        }
        if (!TextUtils.isEmpty(user.getStuno())) {
            tvInfoState.setText("已认证");
            tvInfoState.setBackgroundColor(getResources().getColor(R.color.orange));
        } else {
            tvInfoState.setText("未认证");
            tvInfoState.setBackgroundColor(getResources().getColor(R.color.gray));
        }

    }

    @Override
    public void initListener() {

    }


    private void logout() {
        BmobUser.logOut();   //清除缓存用户对象
        getActivity().finish();
        startActivity(new Intent(mActivity, LoginActivity.class));
    }


    @OnClick({R.id.ll_my_info, R.id.ll_my_setting, R.id.ll_my_update, R.id.ll_my_about, R.id.ll_my_feedback, R.id.btn_my_logout})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.ll_my_info:
                intent = new Intent(mActivity, UserInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_my_setting:
                intent = new Intent(mActivity, StudentActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_my_update:
                Toast.makeText(mActivity, "已经是最新版本！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_my_about:
                intent = new Intent(mActivity, AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_my_feedback:
                intent = new Intent(mActivity, FeedbackActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_my_logout:
                AlertDialog UpTeldialog = new AlertDialog.Builder(mActivity)
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                logout();
                            }
                        })
                        .setTitle("退出登录")
                        .setMessage("确定要退出登录吗？")
                        .setIcon(R.mipmap.ic_launcher)
                        .create();
//                UpTeldialog.setCanceledOnTouchOutside(false);
                UpTeldialog.show();
                break;
        }
    }


}

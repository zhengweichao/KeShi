package com.weichao.keshi.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.weichao.keshi.CONFIG;
import com.weichao.keshi.R;
import com.weichao.keshi.bean.JsonRealBean;
import com.weichao.keshi.bean.MyUser;
import com.weichao.keshi.utils.LogUtils;
import com.weichao.keshi.utils.SPUtils;
import com.weichao.keshi.utils.ToastUtil;
import com.weichao.keshi.view.LoadDialog;

import butterknife.Bind;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;
import okhttp3.Call;
import okhttp3.Response;

public class UserInfoActivity extends BaseActivity {

    @Bind(R.id.tv_user_info_name)
    TextView tvUserInfoName;
    @Bind(R.id.tv_user_info_sex)
    TextView tvUserInfoSex;
    @Bind(R.id.tv_user_info_stuno)
    TextView tvUserInfoStuno;
    @Bind(R.id.tv_user_info_tel)
    TextView tvUserInfoTel;
    @Bind(R.id.tv_user_info_yuan)
    TextView tvUserInfoYuan;
    @Bind(R.id.tv_user_info_class)
    TextView tvUserInfoClass;
    @Bind(R.id.tv_user_info_created)
    TextView tvUserInfoCreated;
    @Bind(R.id.ll_user_info_sex)
    LinearLayout llUserInfoSex;
    @Bind(R.id.ll_user_info_stuno)
    LinearLayout llUserInfoStuno;
    @Bind(R.id.ll_user_info_yuan)
    LinearLayout llUserInfoYuan;
    @Bind(R.id.ll_user_info_class)
    LinearLayout llUserInfoClass;
    @Bind(R.id.bt_real_name)
    Button btRealName;
    private EditText et_real_stuno;
    private EditText et_real_name;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user_info;
    }

    @Override
    void initData() {
        MyUser user = BmobUser.getCurrentUser(MyUser.class);
        tvUserInfoTel.setText(user.getMobilePhoneNumber());
        tvUserInfoCreated.setText(user.getCreatedAt());

        if (!TextUtils.isEmpty(user.getStuno())) {
            tvUserInfoName.setText(user.getUsername());
            tvUserInfoSex.setText(user.getSex());
            tvUserInfoStuno.setText(user.getStuno());
            tvUserInfoYuan.setText(user.getYuan());
            tvUserInfoClass.setText(user.getClazz());
            btRealName.setVisibility(View.GONE);
        } else {
            tvUserInfoName.setText("未进行实名认证");
            tvUserInfoSex.setText("未进行实名认证");
            tvUserInfoStuno.setText("未进行实名认证");
            tvUserInfoYuan.setText("未进行实名认证");
            tvUserInfoClass.setText("未进行实名认证");
            llUserInfoSex.setOnClickListener(this);
            llUserInfoClass.setOnClickListener(this);
            llUserInfoStuno.setOnClickListener(this);
            llUserInfoYuan.setOnClickListener(this);
        }
    }

    @Override
    void processClick(View v) {

        switch (v.getId()) {
            case R.id.ll_user_info_class:
            case R.id.ll_user_info_sex:
            case R.id.ll_user_info_stuno:
            case R.id.ll_user_info_yuan:
                RealName();
            default:
                break;
        }
    }

    private void RealName() {
        View view = LayoutInflater.from(UserInfoActivity.this).inflate(R.layout.dialog_reallyname, null);
        et_real_stuno = (EditText) view.findViewById(R.id.et_real_stuno);
        et_real_name = (EditText) view.findViewById(R.id.et_real_name);

        AlertDialog dialog = new AlertDialog.Builder(UserInfoActivity.this)
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = et_real_name.getText().toString().trim();
                        String stuno = et_real_stuno.getText().toString().trim();
                        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(stuno)) {
                            ToastUtil.show(UserInfoActivity.this, "请填写完整信息", Toast.LENGTH_SHORT);
                        } else {
                            UpdateReal();
                        }
                    }
                })
                .setTitle("实名认证")
                .setIcon(R.mipmap.ic_launcher)
                .setView(view)
                .create();
        dialog.show();
    }

    private void UpdateReal() {
        LoadDialog.show(UserInfoActivity.this);
        String name = et_real_name.getText().toString().trim();
        final String stuno = et_real_stuno.getText().toString().trim();
        OkGo.get(CONFIG.URL_QUERY)
                .params("stuname", name)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Log.e("zwc", "onSuccess: " + s);
                        JsonRealBean jsonRealBean = new Gson().fromJson(s, JsonRealBean.class);
                        Log.e("zwc", "onSuccess: " + jsonRealBean.getList().get(0).getStu_no() + ":::::" + jsonRealBean.getList().size());
                        for (int i = 0; i < jsonRealBean.getList().size(); i++) {
                            if (stuno.equals(jsonRealBean.getList().get(i).getStu_no() + "")) {
                                Log.e("zwc", "onSuccess: 11111");
                                tvUserInfoName.setText(jsonRealBean.getList().get(i).getName());
                                tvUserInfoSex.setText(jsonRealBean.getList().get(i).getSex());
                                tvUserInfoStuno.setText(jsonRealBean.getList().get(i).getStu_no());
                                tvUserInfoYuan.setText(jsonRealBean.getList().get(i).getYuanxi());
                                tvUserInfoClass.setText(jsonRealBean.getList().get(i).getZhuanye());
                                SPUtils.put(UserInfoActivity.this, "real", "true");
                                Log.e("zwc", "onSuccess: 实名认证成功！");

                                MyUser bean = new MyUser();
                                bean.setUsername(jsonRealBean.getList().get(i).getName());
                                bean.setSex(jsonRealBean.getList().get(i).getSex());
                                bean.setClazz(jsonRealBean.getList().get(i).getZhuanye());
                                bean.setYuan(jsonRealBean.getList().get(i).getYuanxi());

                                MyUser bmobUser = BmobUser.getCurrentUser(MyUser.class);
                                bmobUser.update(bmobUser.getObjectId(), new UpdateListener() {

                                    @Override
                                    public void done(BmobException e) {
                                        if (e == null) {
                                            LogUtils.e("个人信息更新成功！");
                                            btRealName.setVisibility(View.GONE);
                                            ToastUtil.show(UserInfoActivity.this, "实名认证成功", Toast.LENGTH_SHORT);
                                        } else {
                                            LogUtils.e("错误：" + e.getMessage());
                                            ToastUtil.show(UserInfoActivity.this, "实名认证失败", Toast.LENGTH_SHORT);
                                        }
                                    }
                                });
                                LoadDialog.dismiss(UserInfoActivity.this);
                                return;
                            }
                        }
                        LoadDialog.dismiss(UserInfoActivity.this);
                    }
                });
    }

    @OnClick(R.id.bt_real_name)
    public void onViewClicked() {
        RealName();
    }
}

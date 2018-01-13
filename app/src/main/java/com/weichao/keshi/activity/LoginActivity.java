package com.weichao.keshi.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.stephentuso.welcome.WelcomeHelper;
import com.weichao.keshi.R;
import com.weichao.keshi.bean.MyUser;
import com.weichao.keshi.utils.LogUtils;
import com.weichao.keshi.utils.ToastUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;

/**
 * @ 创建时间: 2017/6/13 on 16:03.
 * @ 描述：登录页面
 * @ 作者: 郑卫超 QQ: 2318723605
 */
public class LoginActivity extends Activity {

    @Bind(R.id.input_username)
    EditText et_username;
    @Bind(R.id.input_password)
    EditText et_password;
    @Bind(R.id.btn_login)
    AppCompatButton btn_login;

    private static final int REQUEST_SIGNUP = 0;
    WelcomeHelper welcomeScreen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        welcomeScreen = new WelcomeHelper(this, MyWelcomeActivity.class);
        welcomeScreen.show(savedInstanceState);
    }

    @OnClick({R.id.btn_login, R.id.link_signup})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                //如果内容不合法，则直接返回，显示错误。
                if (!validate()) {
                    onLoginFailed();
                    return;
                }
                login();
                break;
            case R.id.link_signup:
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                finish();
                //动画效果
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                break;
        }
    }

    /**
     * 登录方法
     */
    public void login() {
        //输入合法，将登录按钮置为不可用，显示圆形进度对话框
        btn_login.setEnabled(false);
        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this, R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("登录中...");
        progressDialog.show();
        //获取输入内容
        String username = et_username.getText().toString().trim();
        String password = et_password.getText().toString().trim();
        // 手机号登录
        BmobUser.loginByAccount(username, password, new LogInListener<MyUser>() {
            @Override
            public void done(MyUser user, BmobException e) {
                if (user != null) {
                    LogUtils.e("登录成功:");
                    onLoginSuccess();
                    progressDialog.dismiss();
                } else {
                    LogUtils.e("登录失败");
                    onLoginFailed();
                    progressDialog.dismiss();
                }
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {
                this.finish();
            }
        }
    }

    /**
     * 重写返回键的返回方法
     */
    @Override
    public void onBackPressed() {
        // Disable going back to the ReviewTestActivity
        moveTaskToBack(true);
    }

    /**
     * 登录成功
     */
    public void onLoginSuccess() {
        btn_login.setEnabled(true);
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * 登录失败
     */
    public void onLoginFailed() {
        ToastUtil.show(getBaseContext(), "登陆失败", Toast.LENGTH_LONG);
        btn_login.setEnabled(true);
    }

    /**
     * @return 判断是否账号密码是否合法
     */
    public boolean validate() {
        //设置初值，默认为合法
        boolean valid = true;

        //获取输入内容
        String email = et_username.getText().toString().trim();
        String password = et_password.getText().toString().trim();

        //判断账号
        if (email.isEmpty()) {
            et_username.setError("请输入你的账号");
            valid = false;
        } else {
            et_username.setError(null);
        }
        //判断密码
        if (password.isEmpty()) {
            et_password.setError("请输入你的密码");
            valid = false;
        } else {
            et_password.setError(null);
        }

        return valid;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        welcomeScreen.onSaveInstanceState(outState);
    }



}
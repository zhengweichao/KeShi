package com.weichao.keshi.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.weichao.keshi.R;
import com.weichao.keshi.bean.MyUser;
import com.weichao.keshi.utils.LogUtils;

import butterknife.Bind;
import butterknife.OnClick;
import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * 注册页面
 */
public class SignupActivity extends BaseActivity {
    private static final String TAG = "SignupActivity";

    @Bind(R.id.input_name)
    EditText _nameText;
    @Bind(R.id.input_mobile)
    EditText _mobileText;
    @Bind(R.id.et_password)
    EditText _passwordText;
    @Bind(R.id.input_reEnterPassword)
    EditText _reEnterPasswordText;
    @Bind(R.id.btn_signup)
    Button _signupButton;
    @Bind(R.id.link_login)
    TextView _loginLink;
    @Bind(R.id.input_yanzheng)
    EditText inputYanzheng;
    @Bind(R.id.btn_getcode)
    Button btnGetcode;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_signup;
    }

    @Override
    void initListener() {
        _signupButton.setOnClickListener(this);
        _loginLink.setOnClickListener(this);
    }

    @Override
    void processClick(View v) {
        switch (v.getId()) {
            case R.id.btn_signup:
                signup();
                break;
            case R.id.link_login:
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                break;
            default:
                break;
        }
    }

    public void signup() {
        Log.d(TAG, "Signup");

        String code = inputYanzheng.getText().toString();
        if (!validate()) {
            onSignupFailed();
            return;
        }
        if (code.isEmpty()) {
            inputYanzheng.setError("请输入验证码");
            return;
        } else {
            inputYanzheng.setError(null);
        }

        _signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignupActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("创建账号...");
        progressDialog.show();

        String username = _nameText.getText().toString();
        String mobile = _mobileText.getText().toString();
        String password = _passwordText.getText().toString();

        MyUser bu = new MyUser();
        bu.setUsername(username);
        bu.setPassword(password);
        bu.setMobilePhoneNumber(mobile);
        bu.signOrLogin(code, new SaveListener<MyUser>() {
            @Override
            public void done(MyUser user, BmobException e) {
                if (e == null) {
                    LogUtils.e("注册成功" + user.getUsername() + "-" + user.getMobilePhoneNumber() + "-" + user.getObjectId());
                    onSignupSuccess();
                    //对话框消失
                    progressDialog.dismiss();
                } else {
                    LogUtils.e("注册失败" + e.getMessage());
                    onSignupFailed(1);
                    progressDialog.dismiss();
                }

            }

        });


    }

    /**
     * 注册失败，按钮置为可用
     * 依据传参不同，进行不同吐司
     */
    public void onSignupFailed(int i) {
        if (i == 1) {
            Toast.makeText(getBaseContext(), "该用户名已经被注册", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getBaseContext(), "注册失败", Toast.LENGTH_LONG).show();
        }
        _signupButton.setEnabled(true);
    }

    public void onSignupSuccess() {
        _signupButton.setEnabled(true);
        setResult(RESULT_OK, null);

        Toast.makeText(SignupActivity.this, "注册成功，已自动登录", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(SignupActivity.this, MainActivity.class);
        startActivity(intent);

        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "注册失败", Toast.LENGTH_LONG).show();

        _signupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name = _nameText.getText().toString();
        String mobile = _mobileText.getText().toString();
        String password = _passwordText.getText().toString();
        String reEnterPassword = _reEnterPasswordText.getText().toString();
        String code = inputYanzheng.getText().toString();

        if (name.isEmpty()) {
            _nameText.setError("请输入用户名");
            valid = false;
        } else {
            _nameText.setError(null);
        }

        if (mobile.isEmpty()) {
            _mobileText.setError("请输入有效的手机号");
            valid = false;
        } else {
            _mobileText.setError(null);
        }

        if (password.isEmpty()) {
            _passwordText.setError("请输入有效的密码");
            valid = false;
        } else {
            _passwordText.setError(null);
        }


        if (reEnterPassword.isEmpty() || !(reEnterPassword.equals(password))) {
            _reEnterPasswordText.setError("两次密码输入不一致");
            valid = false;
        } else {
            _reEnterPasswordText.setError(null);
        }

        return valid;
    }

    private CountDownTimer countDownTimer = new CountDownTimer(6800, 1000) {

        @Override
        public void onTick(long millisUntilFinished) {
            btnGetcode.setText(millisUntilFinished / 1000 + "秒后可以重新获取");
        }

        @Override
        public void onFinish() {
            btnGetcode.setText("获取验证码");
            btnGetcode.setEnabled(true);
        }
    };

    @OnClick(R.id.btn_getcode)
    public void onViewClicked() {
        btnGetcode.setEnabled(false);
        if (!validate()) {
            Toast.makeText(this, "信息不完善！", Toast.LENGTH_SHORT).show();
            btnGetcode.setEnabled(true);
            return;
        }
        countDownTimer.start();
        String username = _nameText.getText().toString();
        String mobile = _mobileText.getText().toString();
        String password = _passwordText.getText().toString();

        // TODO: 2017/9/7 获取验证码
        BmobSMS.requestSMSCode(mobile, "keshi", new QueryListener<Integer>() {
            @Override
            public void done(Integer smsId, BmobException ex) {
                if (ex == null) {//验证码发送成功
                    LogUtils.e("验证码发送成功,短信id：" + smsId);//用于查询本次短信发送详情
                    Toast.makeText(SignupActivity.this, "验证码已发送，请注意查收", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
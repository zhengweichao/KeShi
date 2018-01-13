package com.weichao.keshi.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.weichao.keshi.R;
import com.weichao.keshi.utils.DateUtil;
import com.weichao.keshi.utils.TimeUtil;

import butterknife.Bind;
import butterknife.OnClick;

import static com.weichao.keshi.utils.TimeUtil.DATE_FORMAT_DATE;

/**
 * @ 创建时间: 2017/10/3 on 12:49.
 * @ 描述：校历页面
 * @ 作者: 郑卫超 QQ: 2318723605
 */
public class XiaoliActivity extends BaseActivity {

    @Bind(R.id.tv_date_today)
    TextView tvDateToday;
    @Bind(R.id.tv_date_today_nongli)
    TextView tvDateTodayNongli;
    @Bind(R.id.tv_xiaoxi_tips)
    TextView tvXiaoxiTips;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_xiaoli;
    }

    @Override
    void initView() {

    }

    @Override
    void initData() {
        String lunar = DateUtil.getChnieseDate(TimeUtil.getYear(), TimeUtil.getMonth(), TimeUtil.getDate());
        tvDateTodayNongli.setText(lunar);
        String date = TimeUtil.getCurrentTimeInString(DATE_FORMAT_DATE);
        tvDateToday.setText(date);
    }

    @OnClick(R.id.tv_xiaoxi_tips)
    public void onViewClicked() {
        View viewdialog = LayoutInflater.from(XiaoliActivity.this).inflate(R.layout.dialog_xiaoli_tips, null);
        AlertDialog dialog = new AlertDialog.Builder(XiaoliActivity.this)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setView(viewdialog)
                .setIcon(R.mipmap.ic_launcher)
                .create();
        dialog.show();
    }
}

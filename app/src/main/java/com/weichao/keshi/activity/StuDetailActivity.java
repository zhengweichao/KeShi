package com.weichao.keshi.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.weichao.keshi.R;


/**
 * @ 创建时间: 2017/3/25 on 9:47
 * @ 描述: 学生信息查询细节页面
 * @ 作者: 郑卫超 QQ:2318723605
 */

public class StuDetailActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        Log.i("zwc", "onCreate: aaaa");
        super.onCreate(savedInstanceState);
        //得到布局文件
        setContentView(R.layout.activity_stu_detail);

        //初始化View
        initView();

        //初始化界面数据
        initData();

        //绑定监听器与适配器
        initListener();

    }


    public void initView() {
        Log.i("zwc", "initView: 加载细节界面");
        TextView tv_name = (TextView) findViewById(R.id.tv_de_name);
        TextView tv_idcard = (TextView) findViewById(R.id.tv_de_idcard);
        TextView tv_de_address = (TextView) findViewById(R.id.tv_de_address);
        TextView tv_de_birth = (TextView) findViewById(R.id.tv_de_birth);
        TextView tv_de_sex = (TextView) findViewById(R.id.tv_de_sex);
        TextView tv_de_cengci = (TextView) findViewById(R.id.tv_de_cengci);
        TextView tv_de_tezheng = (TextView) findViewById(R.id.tv_de_tezheng);
        TextView tv_de_zhuanye = (TextView) findViewById(R.id.tv_de_zhuanye);
        TextView tv_de_xiaoqu = (TextView) findViewById(R.id.tv_de_xiaoqu);
        TextView tv_de_xuezhi = (TextView) findViewById(R.id.tv_de_xuezhi);
        TextView tv_de_stu_no = (TextView) findViewById(R.id.tv_de_stu_no);
        // ImageButton ibt_delete = (ImageButton) findViewById(R.id.ibt_delete);

        tv_de_stu_no.setText("学号：" + getIntent().getExtras().get("stu_no"));
        tv_de_birth.setText("生日：" + getIntent().getExtras().get("birth"));
        tv_de_sex.setText("性别：" + getIntent().getExtras().get("sex"));
        tv_de_xuezhi.setText("学制：" +  getIntent().getExtras().get("xuezhi"));
        tv_de_address.setText("地址：" +  getIntent().getExtras().get("address"));
        tv_de_cengci.setText("层次：" + getIntent().getExtras().get("cengci"));
        tv_de_tezheng.setText("备注：" + getIntent().getExtras().get("tezheng"));
        tv_de_zhuanye.setText("专业：" + getIntent().getExtras().get("zhuanye"));
        tv_de_xiaoqu.setText("校区：" +  getIntent().getExtras().get("xiaoqu"));
        tv_name.setText("姓名：" + getIntent().getExtras().get("name"));
        tv_idcard.setText("身份证号：" +  getIntent().getExtras().get("idcard"));
    }

    public void initData() {

    }

    public void initListener() {

    }

    public void processClick(View v) {

    }

    public void delete(View v) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        final AlertDialog dialog = builder.create();
//        View view = View.inflate(this, R.layout.dialog_delete, null);
//        Button bt_delete = (Button) view.findViewById(R.id.bt_delete);
//        Button bt_cancel = (Button) view.findViewById(R.id.bt_cancel);
//
//        bt_delete.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Log.e("zwc", "已点击确认删除");
//                StudentDao studentDao = new StudentDao();
//                studentDao.delete("" + getIntent().getExtras().get("stu_no"));
//                Toast.makeText(StuDetailActivity.this, "删除成功", Toast.LENGTH_SHORT)
//                        .show();
//                Log.e("zwc", "已删除");
//                Intent intent = new Intent(StuDetailActivity.this,
//                        MainActivity.class);
////				startActivity(intent);
//                setResult(0, intent);
//                finish();
//
//                dialog.dismiss();
//            }
//        });
//
//        bt_cancel.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//        dialog.setView(view);
//        dialog.show();
    }
}

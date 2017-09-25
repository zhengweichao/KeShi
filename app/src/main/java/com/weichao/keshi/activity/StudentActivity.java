package com.weichao.keshi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.weichao.keshi.R;
import com.weichao.keshi.bean.Student;
import com.weichao.keshi.db.StudentDao;
import com.weichao.keshi.utils.InitDBUtils;

import java.util.List;

public class StudentActivity extends AppCompatActivity {
    private static final String TAG = "zwc";
    private EditText et_location_query;
    private ListView lv_result;
    private List<Student> list;
    private MyAdapter adapter;
    private TextView tv_total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_main);

        InitDBUtils.initDB("stu.db",StudentActivity.this);
        initViews();

    }

    private void initViews() {
        et_location_query = (EditText) findViewById(R.id.et_location_query);
        Button bt_location_query = (Button) findViewById(R.id.bt_location_query);
        Button bt_location_query2 = (Button) findViewById(R.id.bt_local_query_class);
        tv_total = (TextView) findViewById(R.id.tv_total);
        lv_result = (ListView) findViewById(R.id.lv_result);

        //查询按钮
        bt_location_query.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.e("zwc", "点击查询按钮");
                query(0);
            }
        });

        //查询按钮
        bt_location_query2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.e("zwc", "点击按照班级查询按钮");
                query(1);
            }
        });

        //搜索结果点击事件
        lv_result.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long arg3) {
                Student student = list.get(position);
                String idcard = student.getIdcard();
                String name = student.getName();
                Intent intent=new Intent(StudentActivity.this, StuDetailActivity.class);
                intent.putExtra("idcard", idcard);
                intent.putExtra("name", name);
                intent.putExtra("sex", student.getSex());
                intent.putExtra("birth", student.getBirth());
                intent.putExtra("address", student.getAddress());
                intent.putExtra("cengci", student.getCengci());
                intent.putExtra("minzu", student.getMinzu());
                intent.putExtra("xiaoqu", student.getXiaoqu());
                intent.putExtra("tezheng", student.getTezheng());
                intent.putExtra("zhuanye", student.getZhuanye());
                intent.putExtra("stu_no", student.getStu_no());
                intent.putExtra("xuezhi", student.getXuezhi());
                intent.putExtra("kaohao", student.getKaohao());
                Log.e(TAG, "onItemClick: ok"+student.getXuezhi());

                startActivityForResult(intent, 0);
                Log.e(TAG, "onItemClick: 跳转" );

            }
        });

        lv_result.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int arg2, long arg3) {
                // TODO Auto-generated method stub
                Toast.makeText(StudentActivity.this, "aaaaaaa", Toast.LENGTH_SHORT).show();

                return true;
            }
        });

    }
    private void query(int mode) {

        String name = et_location_query.getText().toString().trim();
        //查询逻辑
        if(TextUtils.isEmpty(name)){
            Toast.makeText(StudentActivity.this, "不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.e("zwc", "开始查询");
        list = StudentDao.query(name,mode);
        if(list==null||list.isEmpty()){
            Log.e("zwc", "没有查询结果");
            Toast.makeText(StudentActivity.this, "没有查询结果", Toast.LENGTH_SHORT).show();
        }else{
            Log.e("zwc", "查询完毕，装填数据"+list.size());
            adapter = new MyAdapter();
            lv_result.setAdapter(adapter);
            tv_total.setText("本次查询共有 "+list.size()+" 个结果");
        }
    }

    class MyAdapter extends BaseAdapter {
        public int getCount() {
            return list.size();
        }
        public Student getItem(int position) {
            return list.get(position);
        }
        public long getItemId(int position) {
            return position;
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if(convertView==null){
                holder=new ViewHolder();
                convertView = View.inflate(StudentActivity.this, R.layout.lv_item_stu, null);
                holder.tv_name=(TextView) convertView.findViewById(R.id.tv_name);
                holder.tv_stu_num=(TextView) convertView.findViewById(R.id.tv_stu_num);
                holder.tv_sex=(TextView) convertView.findViewById(R.id.tv_sex);

                convertView.setTag(holder);
            }else{
                holder=(ViewHolder) convertView.getTag();
            }
            final Student bn = getItem(position);
            holder.tv_name.setText("姓名：  "+bn.getName());
            holder.tv_stu_num.setText("学号：  "+bn.getStu_no());
            holder.tv_sex.setText("性别：   "+bn.getSex());

            return convertView;
        }
        class ViewHolder{
            public TextView tv_sex;
            public TextView tv_name;
            public TextView tv_stu_num;
        }
    }
}

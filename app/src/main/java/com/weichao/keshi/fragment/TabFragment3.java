package com.weichao.keshi.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.weichao.keshi.R;
import com.weichao.keshi.activity.AboutActivity;
import com.weichao.keshi.activity.LoginActivity;
import com.weichao.keshi.activity.StudentActivity;
import com.weichao.keshi.adapter.KeyValueAdapter;
import com.weichao.keshi.bean.KeyValue;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobUser;

/**
 * @ 创建时间: 2017/5/21 on 19:39.
 * @ 描述：我的页面fragment
 * @ 作者: 郑卫超 QQ: 2318723605
 */

public class TabFragment3 extends BaseFragment {

    private List<KeyValue> kvScreenList = new ArrayList<KeyValue>();
    private KeyValueAdapter adapterScreen;
    private ListView lvScreen;
    private List<KeyValue> kvOtherList = new ArrayList<KeyValue>();
    private KeyValueAdapter adapterOther;
    private ListView lvOther;
    private Button btn_my_logout;

    @Override
    protected View initView() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.aty_setting, null);
        btn_my_logout = (Button) inflate.findViewById(R.id.btn_my_logout);
        adapterScreen = new KeyValueAdapter(mActivity, kvScreenList);
        lvScreen = (ListView) inflate.findViewById(R.id.lvScreen);
        lvScreen.setAdapter(adapterScreen);

        adapterOther = new KeyValueAdapter(mActivity, kvOtherList);
        lvOther = (ListView) inflate.findViewById(R.id.lvOther);
        lvOther.setAdapter(adapterOther);

        return inflate;
    }

    @Override
    public void initData() {
        initScreen();//加载屏幕显示
        initOther();
    }

    @Override
    public void initListener() {
        btn_my_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
            }
        });

//        菜单监听事件
        lvOther.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent;
                switch (position) {
                    // TODO: 2017/6/26 退出登录
                    case 0:

                        break;
                    // TODO: 2017/6/26 检查更新
                    case 1:
                        Toast.makeText(mActivity, "已经是最新版本！", Toast.LENGTH_SHORT).show();

                        break;

                    // TODO: 2017/6/26  菜单三
                    case 2:
                        intent = new Intent(mActivity, AboutActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
//
        lvScreen.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent;
                switch (position) {
//                    菜单一:学生信息查询
                    case 0:
                        intent = new Intent(mActivity, StudentActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
//                    个人信息


                        break;
                    case 2:

                        break;
                }
            }
        });
    }

    private void logout() {
        BmobUser.logOut();   //清除缓存用户对象
        //TODO 连接：3.2、退出登录需要断开与IM服务器的连接
//                BmobIM.getInstance().disConnect();
        getActivity().finish();
        startActivity(new Intent(mActivity, LoginActivity.class));
    }

    private void initScreen() {
        kvScreenList.clear();
        KeyValue f = new KeyValue("学生信息查询", "");
        kvScreenList.add(f);
        KeyValue s = new KeyValue("个人信息", "");
        kvScreenList.add(s);
        KeyValue c = new KeyValue("菜单三", "");
        kvScreenList.add(c);
    }

    private void initOther() {
        kvOtherList.clear();
        KeyValue kv0 = new KeyValue("退出登录", "");
        kvOtherList.add(kv0);
        KeyValue kv1 = new KeyValue("检查更新", "");
        kvOtherList.add(kv1);
        KeyValue kv2 = new KeyValue("关于", "");
        kvOtherList.add(kv2);

        adapterOther.notifyDataSetChanged();
    }
}

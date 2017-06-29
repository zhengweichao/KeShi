package com.weichao.keshi.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.weichao.keshi.R;
import com.weichao.keshi.adapter.KeyValueAdapter;
import com.weichao.keshi.bean.KeyValue;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建日期:2016/12/9 on 23:08
 * 描述:
 * 作者:郭士超
 * QQ:1169380200
 */

public class AtySetting extends Activity {

    private String id;
    private String token;
    private String code;
    private List<KeyValue> kvScreenList = new ArrayList<KeyValue>();
    private KeyValueAdapter adapterScreen;
    private ListView lvScreen;
    private List<KeyValue> kvOtherList = new ArrayList<KeyValue>();
    private KeyValueAdapter adapterOther;
    private ListView lvOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_setting);
        initScreen();
//        Intent i = getIntent();
//        id = i.getStringExtra(Config.KEY_ID);
//        token = i.getStringExtra(Config.KEY_TOKEN);
//        code = i.getStringExtra(Config.KEY_CODE);

        adapterScreen = new KeyValueAdapter(AtySetting.this, kvScreenList);
        lvScreen = (ListView) findViewById(R.id.lvScreen);
        lvScreen.setAdapter(adapterScreen);

        adapterOther = new KeyValueAdapter(AtySetting.this, kvOtherList);
        lvOther = (ListView) findViewById(R.id.lvOther);
        lvOther.setAdapter(adapterOther);

        initScreen();//加载屏幕显示
        initOther();

        lvScreen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent i;
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
            }
        });

        lvOther.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0:
//                        tyingDevice();//解绑设备
                        break;
                    case 1:
//                        checkUpdates();//检查更新
                        break;
                    case 2:
//                        startActivity(new Intent(AtySetting.this, AtyAbout.class));//关于
                        break;
                }
            }
        });

    }


    private void initScreen() {
        kvScreenList.clear();
        KeyValue f = new KeyValue("第一行显示", "");
        kvScreenList.add(f);
        KeyValue s = new KeyValue("第二行显示", "");
        kvScreenList.add(s);
        KeyValue c = new KeyValue("屏幕颜色", "");
        kvScreenList.add(c);
    }
    private void initOther() {
        KeyValue kv0 = new KeyValue("设备解绑", "");
        kvOtherList.add(kv0);
        KeyValue kv1 = new KeyValue("检查更新", "");
        kvOtherList.add(kv1);
        KeyValue kv2 = new KeyValue("关于", "");
        kvOtherList.add(kv2);

        adapterOther.notifyDataSetChanged();
    }

 /*   private void checkUpdates() {
        new Update("1.0.0", new Update.SuccessCallback() {
            @Override
            public void onSuccess(String errmsg, String msg) {
                AlertDialog.Builder builder;
                switch (errmsg) {
                    case Config.ERRMSG_OK:
                        builder = new AlertDialog.Builder(AtySetting.this);
                        builder.setTitle("是否更新");
                        builder.setMessage("新版本");
                        builder.setPositiveButton("马上更新", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //下载更新
                            }
                        });
                        builder.setNegativeButton("稍后再说", null);

                        builder.show();
                        break;
                    default:
                        builder = new AlertDialog.Builder(AtySetting.this);
                        builder.setTitle("检查更新");
                        builder.setMessage("已经为最新版本");
                        builder.setPositiveButton("确定", null);
                        builder.show();
                        break;
                }

            }
        }, new Update.FailCallback() {
            @Override
            public void onFail(String errmsg, String msg) {
                Toast.makeText(AtySetting.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }*/

   /* private String getDisplayId(KeyValue kvScreen) {
        for (KeyValue kv : Config.displayList) {
            if (kv.getValueStr().equals(kvScreen.getValueStr())) {
                return kv.getKey();
            }
        }
        return "0";
    }*/
}
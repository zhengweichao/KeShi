package com.weichao.keshi.activity;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.BitmapCallback;
import com.lzy.okgo.callback.StringCallback;
import com.weichao.keshi.R;

import okhttp3.Call;
import okhttp3.Response;

public class ClassActivity extends AppCompatActivity {

    private ImageView iv_test1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);
//        test1();
        iv_test1 = (ImageView) findViewById(R.id.iv_test);

        test2();
    }

    private void test2() {
        OkGo.get("http://121.22.25.47/CheckCode.aspx")
                .execute(new BitmapCallback() {
                    @Override
                    public void onSuccess(Bitmap bitmap, Call call, Response response) {
                        Log.e("zwc", "onSuccess: =========aaa===========" );
                        iv_test1.setImageBitmap(bitmap);

                    }
                });

    }

    private void test1() {
        OkGo.post("http://nust.cc/nust/index.php?s=Home/index/chaoApi")
                .params("uid", "0914140230").params("pwd", "weichao211314").params("key", "Ss1OCaN8fqrVIlL3")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Log.e("zwc", "onSuccess:-------- " + s);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        Log.e("zwc", "onError: -------------");
                    }
                });
    }
}

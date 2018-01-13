package com.weichao.keshi;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cookie.store.PersistentCookieStore;
import com.weichao.keshi.bean.DaoMaster;
import com.weichao.keshi.bean.DaoSession;
import com.weichao.keshi.utils.LogUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import cn.bmob.newim.BmobIM;

/**
 * @ 创建时间: 2017/6/10 on 17:36.
 * @ 描述：MyApplication
 * @ 作者: 郑卫超 QQ: 2318723605
 */

public class MyApplication extends Application {
    private static DaoSession daoSession;

    private static MyApplication INSTANCE;

    public static MyApplication INSTANCE() {
        return INSTANCE;
    }

    private void setInstance(MyApplication app) {
        setBmobIMApplication(app);
    }

    private static void setBmobIMApplication(MyApplication a) {
        MyApplication.INSTANCE = a;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        initOKGO();
        if (getApplicationInfo().packageName.equals(getMyProcessName())) {
            BmobIM.init(this);
//            BmobIM.registerDefaultMessageHandler(new DemoMessageHandler());
        }

        //配置数据库
//        setupDatabase();
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setDownsampleEnabled(true)
                .build();
        Fresco.initialize(this, config);
        LogUtils.i("onCreate: MyApplication配置完成。");
    }

    private void initOKGO() {
        //必须调用初始化
        OkGo.init(this);

        try {
            OkGo.getInstance()
                    .debug("OkGo")
                    .setConnectTimeout(OkGo.DEFAULT_MILLISECONDS)  //全局的连接超时时间
                    .setReadTimeOut(OkGo.DEFAULT_MILLISECONDS)     //全局的读取超时时间
                    .setWriteTimeOut(OkGo.DEFAULT_MILLISECONDS)    //全局的写入超时时间
//                    .setCacheMode(CacheMode.NO_CACHE)
                    .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)
                    .setCookieStore(new PersistentCookieStore());          //cookie持久化存储，如果cookie不过期，则一直有效
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 配置数据库
     */
    private void setupDatabase() {
        //创建数据库shop.db"
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "shop.db", null);
        //获取可写数据库
        SQLiteDatabase db = helper.getWritableDatabase();
        // 获取数据库对象
        DaoMaster daoMaster = new DaoMaster(db);
        // 获取Dao对象管理者
        daoSession = daoMaster.newSession();
    }

    /**
     * 获取当前运行的进程名
     *
     * @return
     */
    public static String getMyProcessName() {
        try {
            File file = new File("/proc/" + android.os.Process.myPid() + "/" + "cmdline");
            BufferedReader mBufferedReader = new BufferedReader(new FileReader(file));
            String processName = mBufferedReader.readLine().trim();
            mBufferedReader.close();
            return processName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static DaoSession getDaoInstant() {
        return daoSession;
    }

}

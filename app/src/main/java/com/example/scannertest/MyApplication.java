package com.example.scannertest;

import android.app.Application;
import android.content.Context;

import com.dcdz.loglibrary.CrashHandler;
import com.dcdz.loglibrary.Log4jConfigure;

import org.apache.log4j.Logger;

/**
 * Create by Ljw on 2019/12/11 17:32
 */
public class MyApplication extends Application {

    private static MyApplication context;
    protected static Logger logger = Logger.getLogger(MyApplication.class);

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

        // 初始化记录日志的工具类
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);
        new Thread(){
            @Override
            public void run() {
                Log4jConfigure.configure(getFilesDir().getAbsolutePath());
                logger.info("configure log4j ok");
            }
        }.start();
    }

    public static Context getContext(){
        return context;
    }

}

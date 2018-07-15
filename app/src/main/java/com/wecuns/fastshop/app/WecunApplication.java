package com.wecuns.fastshop.app;

import android.app.Application;

import com.wecuns.zivcore.apps.ZivApp;

/**
 * Created by Administrator on 2018\7\16 0016.
 */

public class WecunApplication extends Application {

    private static final String API_HOST = "http://api.wecuns.com";
    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * 初始化配置信息
         */
        ZivApp.init(this).withConfigApiHost(API_HOST).configure();
    }
}

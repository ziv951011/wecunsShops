package com.wecuns.zivcore.apps;

import android.content.Context;

import java.util.WeakHashMap;

/**
 * 初始化项目 不允许其他类修改
 */
public final class ZivApp {

    public static Configurator init(Context context){
        getConfigurator().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    private static WeakHashMap<String,Object> getConfigurator(){
        return Configurator.getInstance().getZivConfigs();
    }
}

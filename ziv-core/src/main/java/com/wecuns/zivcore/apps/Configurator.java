package com.wecuns.zivcore.apps;


import android.util.Log;

import java.util.WeakHashMap;

/**
 * 存储配置信息 工具类
 */
public class Configurator {

    private static final String TAG = Configurator.class.getSimpleName();

    /**
     * 传说说的是 键值 在不使用的时候 进行自动回收 提供内存消耗
     */
    private static final WeakHashMap<String,Object> ZIV_CONFIGS = new WeakHashMap<>();

    private Configurator() {
        // 配置开始了 但是没有完成初始化
        ZIV_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    /**
     * 线程安全的懒汉内部类
     * @return
     */
    public static Configurator getInstance() {
        return new Hodler().INSTANCE;
    }

    /**
     * 获取配置信息
     * @return
     */
    final WeakHashMap<String, Object> getZivConfigs() {
        return ZIV_CONFIGS;
    }

    private static class Hodler {
        private static final Configurator INSTANCE = new Configurator();
    }

    /**
     * 开始初始化
     */
    public final void configure() {
        // 告诉Application初始化完成
        ZIV_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    /**
     * 配置域名信息
     */
    public final Configurator withConfigApiHost(String host) {
        ZIV_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    /**
     * 检测初始化是否完成
     */
    private void checkConfiguration() {
        final boolean isReady = (boolean) ZIV_CONFIGS.get(ConfigType.CONFIG_READY.name());
        // 没有完成的时候 就使用抛出异常
        if (!isReady) {
            throw new RuntimeException("配置未进行初始化,请检查配置信息");
        } else {
            Log.e(TAG, "init Success");
        }
    }

    /**
     *
     * @param configTypeEnum
     * @param <T> 没有检测
     * @return
     */
    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> configTypeEnum) {
        checkConfiguration();
        return (T) ZIV_CONFIGS.get(configTypeEnum.name());
    }
}

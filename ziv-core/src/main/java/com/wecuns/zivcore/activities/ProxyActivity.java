package com.wecuns.zivcore.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;

import com.wecuns.zivcore.R;
import com.wecuns.zivcore.delegates.ZivDelegates;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by Administrator on 2018\7\16 0016.
 * 代理的Activity 掌管所有的Fragment
 */

public abstract class ProxyActivity extends SupportActivity {

    /**
     * 设置布局
     * @return
     */
    public abstract ZivDelegates setRootDelegates();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContainer(savedInstanceState);
    }

    /**
     * 初始化视图
     */
    public void initContainer(@Nullable Bundle savedInstanceState) {
        final ContentFrameLayout contentFrameLayout = new ContentFrameLayout(this);
        contentFrameLayout.setId(R.id.delegates_container);
        // 设置布局
        setContentView(contentFrameLayout);
        if (savedInstanceState == null) {
            /**
             * 初始化的时候加载根Delegates
             */
            loadRootFragment(R.id.delegates_container, setRootDelegates());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**
         * 执行垃圾回收
         */
        System.gc();
        System.runFinalization();
    }
}

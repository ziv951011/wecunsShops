package com.wecuns.zivcore.delegates;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * Created by Administrator on 2018\7\16 0016.
 */

public abstract class BaseDelegates extends SwipeBackFragment {

    private Unbinder mUnbinder;

    public abstract Object setLayout();

    public abstract void onBindView(@Nullable Bundle savedInstanceState, View root);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = null;
        /**
         * 判断传入的布局是否为布局
         */
        if (setLayout() instanceof Integer) {
            rootView = inflater.inflate((Integer) setLayout(), container, false);
        } else if (setLayout() instanceof View) {
            /**
             * 如果传入的是一个View对象的话 直接进行赋值就可以了
             */
            rootView = (View) setLayout();
        }

        if (rootView != null) {
            mUnbinder = ButterKnife.bind(this, rootView);
            /**
             * 使用绑定
             */
            onBindView(savedInstanceState, rootView);
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    /**
     * 卸载ButterKnife
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }
}

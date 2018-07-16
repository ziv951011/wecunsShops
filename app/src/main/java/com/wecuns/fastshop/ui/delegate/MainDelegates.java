package com.wecuns.fastshop.ui.delegate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.wecuns.fastshop.R;
import com.wecuns.zivcore.delegates.ZivDelegates;

/**
 * Created by Administrator on 2018\7\16 0016.
 *
 */

public class MainDelegates extends ZivDelegates {
    @Override
    public Object setLayout() {
        return R.layout.delegate_main;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View root) {

    }
}

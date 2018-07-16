package com.wecuns.fastshop.ui.activity;



import com.wecuns.fastshop.ui.delegate.MainDelegates;
import com.wecuns.zivcore.activities.ProxyActivity;
import com.wecuns.zivcore.delegates.ZivDelegates;

public class MainActivity extends ProxyActivity {

    @Override
    public ZivDelegates setRootDelegates() {
        return new MainDelegates();
    }

}

package com.oktaybogaz.javachucknorrisdemo;

import android.app.Application;

import com.oktaybogaz.javachucknorrisdemo.di.components.AppComponent;
import com.oktaybogaz.javachucknorrisdemo.di.components.DaggerNetComponent;
import com.oktaybogaz.javachucknorrisdemo.di.components.NetComponent;
import com.oktaybogaz.javachucknorrisdemo.di.modules.AppModule;
import com.oktaybogaz.javachucknorrisdemo.di.modules.NetModule;
import com.oktaybogaz.javachucknorrisdemo.ui.menu.MenuScreenComponent;

public class App extends Application {

    private NetComponent netComponent;
    private MenuScreenComponent menuScreenComponent;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.chucknorris.io/"))
                .build();
//
//        appComponent = DaggerAppComponent.builder()
//                .appModule(new AppModule(this))
//                .netModule(new NetModule("https://api.chucknorris.io/"))
//                .build();

//        netComponent = DaggerNetComponent.builder()
//                .netModule(new NetModule("https://api.chucknorris.io/"))
//                .build();

    }

    public NetComponent getNetComponent() {
        return netComponent;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}

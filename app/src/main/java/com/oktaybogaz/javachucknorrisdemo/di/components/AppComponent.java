package com.oktaybogaz.javachucknorrisdemo.di.components;

import android.app.Application;

import com.oktaybogaz.javachucknorrisdemo.di.modules.AppModule;
import com.oktaybogaz.javachucknorrisdemo.di.modules.NetModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface AppComponent {

    void inject(Application application);

}

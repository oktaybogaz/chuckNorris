package com.oktaybogaz.javachucknorrisdemo.di.components;


import com.oktaybogaz.javachucknorrisdemo.di.modules.AppModule;
import com.oktaybogaz.javachucknorrisdemo.di.modules.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {AppModule.class,NetModule.class})
public interface NetComponent {

    Retrofit retrofit();

}

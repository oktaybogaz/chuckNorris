package com.oktaybogaz.javachucknorrisdemo.ui.menu;

import com.oktaybogaz.javachucknorrisdemo.di.components.NetComponent;

import com.oktaybogaz.javachucknorrisdemo.di.scopes.MyScope;;

import dagger.Component;

@MyScope
@Component(dependencies = NetComponent.class,modules = MenuScreenModule.class)
public interface MenuScreenComponent {

    void inject(MainActivity mainActivity);

}

package com.oktaybogaz.javachucknorrisdemo.ui.detail;

import com.oktaybogaz.javachucknorrisdemo.di.components.NetComponent;
import com.oktaybogaz.javachucknorrisdemo.di.scopes.MyScope;

import dagger.Component;

@MyScope
@Component(dependencies = NetComponent.class,modules = DetailScreenModule.class)
public interface DetailScreenComponent {

    void inject(DetailActivity detailActivity);

}

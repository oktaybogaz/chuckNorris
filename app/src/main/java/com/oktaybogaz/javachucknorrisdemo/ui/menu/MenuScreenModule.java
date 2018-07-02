package com.oktaybogaz.javachucknorrisdemo.ui.menu;

import com.oktaybogaz.javachucknorrisdemo.di.scopes.MyScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class MenuScreenModule {

    private MenuScreenContract.View mView;


    public MenuScreenModule(MenuScreenContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @MyScope
    MenuScreenContract.View providesMenuScreenContractView(){
        return mView;
    }

}

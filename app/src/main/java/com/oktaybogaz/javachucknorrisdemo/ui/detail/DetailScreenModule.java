package com.oktaybogaz.javachucknorrisdemo.ui.detail;

import com.oktaybogaz.javachucknorrisdemo.di.scopes.MyScope;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailScreenModule {
    private DetailScreenContract.View mView;

    public DetailScreenModule(DetailScreenContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @MyScope
    DetailScreenContract.View provideDetailScreenContractView() {
        return mView;
    }
}

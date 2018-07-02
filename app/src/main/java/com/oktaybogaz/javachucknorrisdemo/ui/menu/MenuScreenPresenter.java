package com.oktaybogaz.javachucknorrisdemo.ui.menu;

import com.oktaybogaz.javachucknorrisdemo.ApiServices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import dagger.Component;
import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MenuScreenPresenter implements MenuScreenContract.Presenter {

    Retrofit retrofit;
    MenuScreenContract.View mView;

    @Inject
    public MenuScreenPresenter(Retrofit retrofit, MenuScreenContract.View mView) {
        this.retrofit = retrofit;
        this.mView = mView;
    }

    @Override
    public void loadCategories() {

        retrofit.create(ApiServices.class).getCategories().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<String[]>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String[] strings) {
                        List<String> categories = new ArrayList<>();
                        categories.addAll(Arrays.asList(strings));
                        mView.showCategories(categories);
                    }
                });



    }
}

package com.oktaybogaz.javachucknorrisdemo.ui.detail;

import com.oktaybogaz.javachucknorrisdemo.models.Joke;

public interface DetailScreenContract {

    interface View {

        void showJoke(Joke joke);

    }

    interface Presenter {

        void loadJoke(String categories);
    }
}

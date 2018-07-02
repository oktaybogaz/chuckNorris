package com.oktaybogaz.javachucknorrisdemo.ui.menu;

import java.util.List;

public interface MenuScreenContract {

    interface View {

        void showCategories(List<String> categoriesList);
    }

    interface Presenter {

        void loadCategories();
    }
}

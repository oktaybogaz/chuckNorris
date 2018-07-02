package com.oktaybogaz.javachucknorrisdemo.ui.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.oktaybogaz.javachucknorrisdemo.App;
import com.oktaybogaz.javachucknorrisdemo.R;
import com.oktaybogaz.javachucknorrisdemo.ui.adapters.CategoriesAdapter;
import com.oktaybogaz.javachucknorrisdemo.ui.detail.DetailActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements MenuScreenContract.View {


    @BindView(R.id.rvCategories)
    RecyclerView rvCategories;

    @Inject
    public MenuScreenPresenter menuScreenPresenter;

    private CategoriesAdapter categoriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        DaggerMenuScreenComponent.builder()
                .netComponent(((App) getApplicationContext())
                        .getNetComponent())
                .menuScreenModule(new MenuScreenModule(this))
                .build().inject(this);

        initRecyclerView();

        menuScreenPresenter.loadCategories();

    }

    private void initRecyclerView() {
        rvCategories.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        categoriesAdapter = new CategoriesAdapter(this);
        rvCategories.setAdapter(categoriesAdapter);

        categoriesAdapter.setOnRowClickListener(onRowClickListener);

    }

    @Override
    public void showCategories(List<String> categoriesList) {

        categoriesAdapter.updateAdapter(categoriesList);
        categoriesAdapter.notifyDataSetChanged();

    }

    CategoriesAdapter.OnRowClickListener onRowClickListener = new CategoriesAdapter.OnRowClickListener() {
        @Override
        public void onRowclickListener(String categoryName) {

            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("Categories.Type", categoryName);
            startActivity(intent);

        }
    };
}

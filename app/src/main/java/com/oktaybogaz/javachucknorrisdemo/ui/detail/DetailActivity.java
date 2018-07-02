package com.oktaybogaz.javachucknorrisdemo.ui.detail;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;

import com.oktaybogaz.javachucknorrisdemo.App;
import com.oktaybogaz.javachucknorrisdemo.R;
import com.oktaybogaz.javachucknorrisdemo.models.Joke;
import com.oktaybogaz.javachucknorrisdemo.ui.menu.DaggerMenuScreenComponent;
import com.oktaybogaz.javachucknorrisdemo.ui.menu.MenuScreenModule;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity implements DetailScreenContract.View {

    @BindView(R.id.ivJoke)
    AppCompatImageView ivJoke;

    @BindView(R.id.tvJoke)
    AppCompatTextView tvJoke;

    @BindView(R.id.srLayout)
    SwipeRefreshLayout srLayout;

    @Inject
    DetailScreenPresenter detailScreenPresenter;

    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        DaggerDetailScreenComponent.builder()
                .netComponent(((App) getApplicationContext())
                        .getNetComponent())
                .detailScreenModule(new DetailScreenModule(this))
                .build().inject(this);

        extras = getIntent().getExtras();

        detailScreenPresenter.loadJoke(extras.getString("Categories.Type"));


        srLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                srLayout.setRefreshing(true);

                detailScreenPresenter.loadJoke(extras.getString("Categories.Type"));

            }
        });
    }

    @Override
    public void showJoke(Joke joke) {



        tvJoke.setText(joke.getValue());
        Picasso.get().load(joke.getIconUrl()).into(ivJoke);
        srLayout.setRefreshing(false);


    }
}

package com.oktaybogaz.javachucknorrisdemo;



import com.oktaybogaz.javachucknorrisdemo.models.Joke;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiServices {

    @GET("jokes/categories")
    Observable<String[]> getCategories();

    @GET("jokes/random")
    Observable<Joke> getJoke(@Query("category") String category);

}

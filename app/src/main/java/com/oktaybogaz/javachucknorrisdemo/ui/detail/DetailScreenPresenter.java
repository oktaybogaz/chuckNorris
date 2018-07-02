package com.oktaybogaz.javachucknorrisdemo.ui.detail;

import android.support.annotation.VisibleForTesting;
import android.test.suitebuilder.annotation.SmallTest;
import android.util.Log;

import com.oktaybogaz.javachucknorrisdemo.ApiServices;
import com.oktaybogaz.javachucknorrisdemo.models.Joke;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@VisibleForTesting
public class DetailScreenPresenter implements DetailScreenContract.Presenter {

    Retrofit retrofit;
    DetailScreenContract.View mView;

    @Inject
    public DetailScreenPresenter(Retrofit retrofit, DetailScreenContract.View mView) {
        this.retrofit = retrofit;
        this.mView = mView;
    }


    @Override
    public void loadJoke(String categories) {

        retrofit.create(ApiServices.class)
                .getJoke(categories)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<Joke>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Joke joke) {

                        mView.showJoke(joke);


                        String words = checkWords(joke.getValue());
                        System.out.println(words);


                        String letters = checkLetters(joke.getValue());
                        System.out.println(letters);

                    }
                });
    }

    public String checkWords(String sentence) {

        sentence = sentence.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : sentence.split(" ")) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }

        return wordCount.toString();
    }

    public String checkLetters(String sentence) {

        sentence = sentence.replaceAll(" ", "");
        sentence = sentence.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Map<String, Integer> letterCount = new HashMap<>();
        for (String letter : sentence.split("")) {
            if (!letter.isEmpty()) {
                if (letterCount.containsKey(letter)) {
                    letterCount.put(letter, letterCount.get(letter) + 1);
                } else {
                    letterCount.put(letter, 1);
                }
            }
        }
        return letterCount.toString();

    }
}

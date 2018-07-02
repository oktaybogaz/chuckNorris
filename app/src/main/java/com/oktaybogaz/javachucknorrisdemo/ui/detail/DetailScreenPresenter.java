package com.oktaybogaz.javachucknorrisdemo.ui.detail;

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

                        countTheWord(editPunctiation(joke.getValue()));

                        countTheLetter(destroySpaces(joke.getValue()));


                    }
                });
    }

    private void countTheWord(String sentence) {

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : sentence.split(" ")) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }

        System.out.println(wordCount.toString());
    }

    private void countTheLetter(String sentence) {

        Map<String, Integer> letterCount = new HashMap<>();

        String newSentence = editPunctiation(sentence);

        for (String letter : newSentence.split("")) {

                if (letterCount.containsKey(letter)) {
                    letterCount.put(letter, letterCount.get(letter) + 1);
                } else {
                    letterCount.put(letter, 1);
                }

            }
        System.out.println(letterCount.toString());

    }

    private String destroySpaces(String sentence) {

        String newSentence = sentence.trim().toLowerCase();
        newSentence = newSentence.replaceAll(" ","");

        return newSentence;

    }

    private String editPunctiation(String sentence) {

       sentence = sentence.replaceAll("[^a-zA-Z ]","").toLowerCase();

        return sentence;
    }
}

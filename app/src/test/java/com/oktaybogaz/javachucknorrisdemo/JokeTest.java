package com.oktaybogaz.javachucknorrisdemo;

import android.test.suitebuilder.annotation.SmallTest;

import com.oktaybogaz.javachucknorrisdemo.models.Joke;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;
import java.util.Map;


@RunWith(JUnit4.class)
@SmallTest
public class JokeTest {

    @Test
    public void myTest(Joke joke) {


        Assert.assertTrue(joke.getValue(), true);
        countTheWord(joke.getValue());
        countTheLetter(joke.getValue());

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
        String destroySpace = sentence.trim();
        Map<String, Integer> letterCount = new HashMap<>();
        for (String letter : destroySpace.split("")) {

            if (letterCount.containsKey(letter)) {
                letterCount.put(letter, letterCount.get(letter) + 1);
            } else {
                letterCount.put(letter, 1);
            }
        }
        System.out.println(letterCount.toString());

    }
}

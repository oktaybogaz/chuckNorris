package com.oktaybogaz.javachucknorrisdemo;

import com.oktaybogaz.javachucknorrisdemo.ui.detail.DetailScreenPresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class JokeTest {


    @InjectMocks
    DetailScreenPresenter presenter;

    private String testWordSentence = "The 1972 Miami Dolphins lost one game, it was a game vs. Chuck Norris and three seven year old girls. Chuck Norris won with a roundhouse-kick to the face in overtime.";
    ;
    private String testWordSentenceResult = "{game=2, year=1, seven=1, girls=1, three=1, miami=1, 1972=1, lost=1, and=1, won=1, a=2, in=1, old=1, one=1, was=1, it=1, norris=2, the=2, with=1, face=1, roundhousekick=1, overtime=1, dolphins=1, to=1, chuck=2, vs=1}";

    private String testLetterSentence = testWordSentence;
    private String testLetterSentenceResult = "{a=9, c=6, d=4, e=14, f=1, g=3, h=8, i=11, k=4, l=4, m=5, n=9, o=11, p=1, 1=1, 2=1, r=9, s=9, t=8, u=4, v=3, 7=1, w=3, 9=1, y=1}";

    @Before
    public void loadSentences() {

        testWordSentence = "The 1972 Miami Dolphins lost one game, it was a game vs. Chuck Norris and three seven year old girls. Chuck Norris won with a roundhouse-kick to the face in overtime.";
        testWordSentenceResult = "{game=2, year=1, seven=1, girls=1, three=1, miami=1, 1972=1, lost=1, and=1, won=1, a=2, in=1, old=1, one=1, was=1, it=1, norris=2, the=2, with=1, face=1, roundhousekick=1, overtime=1, dolphins=1, to=1, chuck=2, vs=1}";

        testLetterSentence = "The 1972 Miami Dolphins lost one game, it was a game vs. Chuck Norris and three seven year old girls. Chuck Norris won with a roundhouse-kick to the face in overtime.";
        testLetterSentenceResult = "{a=9, c=6, d=4, e=14, f=1, g=3, h=8, i=11, k=4, l=4, m=5, n=9, o=11, p=1, 1=1, 2=1, r=9, s=9, t=8, u=4, v=3, 7=1, w=3, 9=1, y=1}";

    }

    @Test
    public void checkWords() throws Exception {

        String wordsMap = presenter.checkWords(testWordSentence);

        System.out.println(wordsMap);

        if (wordsMap.equals(testWordSentenceResult)) {

            Assert.assertTrue(true);

        } else {

            Assert.assertTrue(false);
        }

    }

    @Test
    public void checkLetters() throws Exception {


        String lettersMap = presenter.checkLetters(testLetterSentence);

        System.out.println(lettersMap);

        if (lettersMap.equals(testLetterSentenceResult)) {

            Assert.assertTrue(true);

        } else {

            Assert.assertTrue(false);

        }

    }


}

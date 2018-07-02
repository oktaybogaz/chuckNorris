package com.oktaybogaz.javachucknorrisdemo;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.SmallTest;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }
}

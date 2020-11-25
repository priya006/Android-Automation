package com.example.navigationapp;

import android.Manifest;
import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import androidx.test.rule.GrantPermissionRule;

import com.squareup.spoon.Spoon;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;
import org.junit.Rule;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)


public class ExampleInstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<>(MainActivity.class);
//    @Rule
//    public GrantPermissionRule mRuntimePermissionRule = GrantPermissionRule.grant(Manifest.permission.READ_CONTACTS).grant(Manifest.permission.WRITE_CONTACTS);
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.navigationapp", appContext.getPackageName());
    }


    @Test
    public void clickButtonHome() {

        onView(withId(R.id.navigation_home)).perform(click()).check(matches(isDisplayed()));

        Spoon.screenshot(activityActivityTestRule.getActivity(), "Home_Button");

    }

    @Test
    public void clickButtonDashboard(){
        onView(withId(R.id.navigation_dashboard)).perform(click()).check(matches(isDisplayed()));
    }


    @Test
    public void clickButtonNotification(){
        onView(withId(R.id.navigation_notifications)).perform(click()).check(matches(isDisplayed()));
    }
    }
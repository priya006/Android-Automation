package com.example.navigationapp;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class TestUsingUIRecorder {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testUsingUIRecorder() {
        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.navigation_dashboard), withContentDescription("Dashboard"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0),
                                1),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());

        ViewInteraction bottomNavigationItemView2 = onView(
                allOf(withId(R.id.navigation_dashboard), withContentDescription("Dashboard"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0),
                                1),
                        isDisplayed()));
        bottomNavigationItemView2.perform(click());

        ViewInteraction bottomNavigationItemView3 = onView(
                allOf(withId(R.id.navigation_dashboard), withContentDescription("Dashboard"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0),
                                1),
                        isDisplayed()));
        bottomNavigationItemView3.perform(click());

        ViewInteraction bottomNavigationItemView4 = onView(
                allOf(withId(R.id.navigation_home), withContentDescription("Home"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0),
                                0),
                        isDisplayed()));
        bottomNavigationItemView4.perform(click());

        ViewInteraction bottomNavigationItemView5 = onView(
                allOf(withId(R.id.navigation_home), withContentDescription("Home"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0),
                                0),
                        isDisplayed()));
        bottomNavigationItemView5.perform(click());

        ViewInteraction bottomNavigationItemView6 = onView(
                allOf(withId(R.id.navigation_notifications), withContentDescription("Notifications"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0),
                                2),
                        isDisplayed()));
        bottomNavigationItemView6.perform(click());

        ViewInteraction bottomNavigationItemView7 = onView(
                allOf(withId(R.id.navigation_notifications), withContentDescription("Notifications"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0),
                                2),
                        isDisplayed()));
        bottomNavigationItemView7.perform(click());

        pressBack();


        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        ViewInteraction imageView = onView(
//                allOf(childAtPosition(
//                        allOf(withId(com.google.android.apps.nexuslauncher.R.id.apps_list_view),
//                                childAtPosition(
//                                        withId(com.google.android.apps.nexuslauncher.R.id.main_content),
//                                        2)),
//                        5),
//                        isDisplayed()));
//        imageView.check(matches(isDisplayed()));

//        ViewInteraction frameLayout = onView(
//                allOf(withId(com.google.android.apps.nexuslauncher.R.id.launcher),
//                        childAtPosition(
//                                allOf(withId(android.R.id.content),
//                                        childAtPosition(
//                                                IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
//                                                0)),
//                                0),
//                        isDisplayed()));
//        frameLayout.check(matches(isDisplayed()));

//        ViewInteraction frameLayout2 = onView(
//                allOf(withId(com.google.android.apps.nexuslauncher.R.id.launcher),
//                        childAtPosition(
//                                allOf(withId(android.R.id.content),
//                                        childAtPosition(
//                                                IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
//                                                0)),
//                                0),
//                        isDisplayed()));
//        frameLayout2.check(matches(isDisplayed()));

//        ViewInteraction frameLayout3 = onView(
//                allOf(withId(com.google.android.apps.nexuslauncher.R.id.launcher),
//                        childAtPosition(
//                                allOf(withId(android.R.id.content),
//                                        childAtPosition(
//                                                IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
//                                                0)),
//                                0),
//                        isDisplayed()));
//        frameLayout3.check(matches(isDisplayed()));

//        ViewInteraction relativeLayout = onView(
//                allOf(withId(com.google.android.apps.nexuslauncher.R.id.main_content),
//                        childAtPosition(
//                                allOf(withId(com.google.android.apps.nexuslauncher.R.id.apps_view),
//                                        childAtPosition(
//                                                withId(com.google.android.apps.nexuslauncher.R.id.drag_layer),
//                                                1)),
//                                0),
//                        isDisplayed()));
//        relativeLayout.check(matches(isDisplayed()));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}

package com.example.sccl;

import android.view.View;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4Builder;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnitRunner;

import junit.framework.JUnit4TestAdapter;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import org.junit.runner.*;
import org.junit.runners.model.Statement;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(JUnit4.class)
@LargeTest
public class MainActivityTest {
    private String string;
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule=new ActivityTestRule<>(MainActivity.class);

    @Before
    public void initValidString(){
        string="Espresso";
    }
    @Test
    public void onClickActivity(){
        onView(withId(R.id.e)).perform(click()).check(matches(withText("e")));
//        onView(withId(R.id.assgin)).perform(click()).check(matches(matches(withText(""))));
        onView(withId(R.id.button69)).perform(click()).check(matches(withText("9")));
        onView(withId(R.id.button23)).perform(click()).check(matches(withText("8")));
        onView(withId(R.id.button39)).perform(click()).check(matches(withText("7")));
        onView(withId(R.id.button70)).perform(click()).check(matches(withText("6")));
        onView(withId(R.id.button40)).perform(click()).check(matches(withText("5")));
        onView(withId(R.id.button48)).perform(click()).check(matches(withText("4")));
        onView(withId(R.id.button71)).perform(click()).check(matches(withText("3")));
        onView(withId(R.id.button53)).perform(click()).check(matches(withText("1")));
        onView(withId(R.id.button52)).perform(click()).check(matches(withText("2")));
        onView(withId(R.id.button51)).perform(click()).check(matches(withText("0")));
        onView(withId(R.id.button68)).perform(click()).check(matches(withText(".")));
        onView(withId(R.id.button28)).perform(click()).check(matches(withText("=")));
        onView(withId(R.id.button55)).perform(click()).check(matches(withText("+")));
        onView(withId(R.id.button37)).perform(click()).check(matches(withText("-")));
        onView(withId(R.id.button75)).perform(click()).check(matches(withText("×")));
        onView(withId(R.id.button63)).perform(click()).check(matches(withText("÷")));
//        onView(withId(R.id.button65)).perform(click()).check(matches(withText("del")));
//        onView(withId(R.id.button64)).perform(click()).check(matches(isDisplayed()));ac
        onView(withId(R.id.button67)).perform(click()).check(matches(withText("y")));
        onView(withId(R.id.button73)).perform(click()).check(matches(withText("x")));
        onView(withId(R.id.button9)).perform(click()).check(matches(withText("sin")));
        onView(withId(R.id.button35)).perform(click()).check(matches(withText("cos")));
        onView(withId(R.id.button31)).perform(click()).check(matches(withText("tan")));
        onView(withId(R.id.button21)).perform(click()).check(matches(withText("(")));
        onView(withId(R.id.button3)).perform(click()).check(matches(withText(")")));
//        onView(withId(R.id.button5)).perform(click()).check(matches(isDisplayed()));pi
        onView(withId(R.id.button26)).perform(click()).check(matches(withText("lg")));
        onView(withId(R.id.button25)).perform(click()).check(matches(withText("^")));
//        onView(withId(R.id.button4)).perform(click()).check(matches(isDisplayed()));
//        onView(withId(R.id.button10)).perform(click()).check(matches(isDisplayed()));
//        onView(withId(R.id.button32)).perform(click()).check(matches(isDisplayed()));
        onView(withId(R.id.button666)).perform(click()).check(matches(withText("ln")));
//        onView(withId(R.id.ln)).perform(click()).check(matches(isDisplayed()));



    }



}

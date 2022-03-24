package com.example.espressotemplate

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class NavigationSuite {

    // A rule which opens an activity for all test methods
    @get: Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun goToInputFormAndGoBack() {

        // Open login page from main page
        onView(withId(R.id.login_btn)).perform(click())

        // Check if page elements are displayed
        onView(withId(R.id.username)).check(matches(isDisplayed()))
        onView(withId(R.id.password)).check(matches(isDisplayed()))
        onView(withId(R.id.login)).check(matches(isDisplayed()))

        // Go back with system button
        pressBack()

        // Check if main activity is displayed
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun goToRecyclerViewPageAndGoBack() {

        // Open recycler page from main page
        onView(withId(R.id.recycler_btn)).perform(click())

        // Check if recycler page is opened
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))

        // Go back with system button
        pressBack()

        // Check if main activity is displayed
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun goToToastPageAndGoBack() {

        // Open toast page from main page
        onView(withId(R.id.toast_btn)).perform(click())

        // Check if toast page is opened
        onView(withId(R.id.make_a_toast_btn)).check(matches(isDisplayed()))

        // Go back with system button
        pressBack()

        // Check if main activity is displayed
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun goToWebViewPageAndGoBack() {

        // Open webView page from main page
        onView(withId(R.id.webview_btn)).perform(click())

        // Check if webView page is opened
        onView(withId(R.id.web_view)).check(matches(isDisplayed()))

        // Go back with system button
        pressBack()

        // Check if main activity is displayed
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun goToDialerPageAndGoBack() {

        // Open dialer page from main page
        onView(withId(R.id.dialer_intent_btn)).perform(click())

        // Check if webView page is opened
        onView(withId(R.id.editTextPhone)).check(matches(isDisplayed()))
        onView(withId(R.id.make_call_button)).check(matches(isDisplayed()))

        // Go back with system button
        pressBack()

        // Check if main activity is displayed
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }
}
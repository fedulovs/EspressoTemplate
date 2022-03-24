package com.example.espressotemplate

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ActivityTest {

    @Test
    fun isActivityOpened() {

        // Open activity
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        // Check if activity is opened
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun isPageElementsDisplayed() {

        // Open activity
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        // Check if buttons are visible
        onView(withId(R.id.login_btn)).check(matches(isDisplayed()))
        onView(withId(R.id.recycler_btn)).check(matches(isDisplayed()))
        onView(withId(R.id.toast_btn)).check(matches(isDisplayed()))
        onView(withId(R.id.webview_btn)).check(matches(isDisplayed()))
        onView(withId(R.id.dialer_intent_btn)).check(matches(isDisplayed()))
        onView(withId(R.id.idling_resource_btn)).check(matches(isDisplayed()))
    }
}
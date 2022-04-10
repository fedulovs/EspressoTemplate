package com.example.espressotemplate

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ToastMessageTest {
    @Test
    fun checkToastMessage() {

        val toastText = "Toast is displayed"

        // Open main activity
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        // Open ToastScreen
        onView(withId(R.id.toast_btn)).perform(click())

        // Click on toast button
        onView(withId(R.id.make_a_toast_btn)).perform(click())

        // Assert the toast is displayed
        // works on api < 30
        onView(withText(toastText))
            .inRoot(ToastMatcher())
            .check(matches(isDisplayed()))
    }
}
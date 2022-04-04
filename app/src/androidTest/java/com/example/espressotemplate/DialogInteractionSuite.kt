package com.example.espressotemplate

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DialogInteractionSuite {

    @Test
    fun writeNameInDialogAndClickOk() {

        val activityScenario = ActivityScenario.launch(DialogActivity::class.java)
        val EXPECTED_NAME = "Juan"

        // Click on dialog button
        onView(withId(R.id.button_launch_dialog)).perform(click())

        // Enter text in dialog input
        onView(withId(R.id.md_input_message)).perform(typeText(EXPECTED_NAME))

        // Click OK
        onView(withText(R.string.text_ok)).perform(click())

        // Check if dialog is closed
        onView(withText(R.string.text_enter_name)).check(doesNotExist())

        // Check if expected name is displayed
        onView(withId(R.id.text_name)).check(matches(withText(EXPECTED_NAME)))
    }

    @Test
    fun clickOkWithEmptyName() {
        val activityScenario = ActivityScenario.launch(DialogActivity::class.java)

        // Click on dialog button
        onView(withId(R.id.button_launch_dialog)).perform(click())

        // Click OK
        onView(withText(R.string.text_ok)).perform(click())

        // Check if dialog is still opened
        onView(withText(R.string.text_enter_name)).check(matches(isDisplayed()))
    }
}
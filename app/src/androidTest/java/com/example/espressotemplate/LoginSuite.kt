package com.example.espressotemplate

import android.content.res.Resources
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.espressotemplate.ui.login.LoginActivity
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginSuite {

    @Before
    fun setUp() {
        // Open login activity
        launch(LoginActivity::class.java)
    }

    @Test
    fun assertLoginPageIsOpened() {
        onView(withId(R.id.username)).check(matches(isDisplayed()))
        onView(withId(R.id.password)).check(matches(isDisplayed()))
        onView(withId(R.id.login)).check(matches(isDisplayed()))
    }

    @Test
    fun positiveLogin() {
        val toastText = "Welcome ! Jane Doe"

        // fill in login
        onView(withId(R.id.username)).perform(typeText("asdasdsd"))

        // fill in password
        onView(withId(R.id.password)).perform(typeText("sadasdas"))

        // close keyboard
        closeSoftKeyboard()

        // click login button
        onView(withId(R.id.login)).perform(click())

        // TODO: assert toast is displayed
        onView(withText(toastText))
            .inRoot(ToastMatcher())
            .check(matches(isDisplayed()))
    }

    @Test
    fun invalidPasswordTest() {

        val resources: Resources = InstrumentationRegistry.getInstrumentation().targetContext.resources
        val errorText = resources.getString(R.string.invalid_password)

        // fill in login
        onView(withId(R.id.username)).perform(typeText("asdasdsd"))

        // fill in password
        onView(withId(R.id.password)).perform(typeText("1234"))

        // click on password input
        onView(withId(R.id.password)).perform(click())

        // assert error message is displayed
        onView(withId(R.id.password)).check(matches(hasErrorText(errorText)))
    }
}
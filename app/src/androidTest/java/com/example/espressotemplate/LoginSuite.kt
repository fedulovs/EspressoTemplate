package com.example.espressotemplate

import android.content.res.Resources
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.espressotemplate.ui.login.LoginActivity
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import pages.LoginPage

@RunWith(AndroidJUnit4::class)
class LoginSuite {

    private val toastText = "Welcome ! Jane Doe"

    @Before
    fun setUp() {
        // Open login activity
        launch(LoginActivity::class.java)
    }

    @Test
    fun assertLoginPageIsOpened() {
        LoginPage()
            .assertPageIsDisplayed()
    }

    @Test
    fun positiveLogin() {
        LoginPage()
            .enterLoginText("asdasdsd")
            .enterPasswordText("asdasdsd")
            .closeKeyboard()
            .clickLoginButton()
            .assertToastIsDisplayed(toastText)
    }

    @Test
    fun invalidPasswordTest() {

        val resources: Resources = InstrumentationRegistry.getInstrumentation().targetContext.resources
        val errorText = resources.getString(R.string.invalid_password)

        LoginPage()
            .enterLoginText("asdasdsd")
            .enterPasswordText("1234")
            .clickOnPasswordInput()
            .assertErrorMessageIsDisplayed(errorText)
    }
}
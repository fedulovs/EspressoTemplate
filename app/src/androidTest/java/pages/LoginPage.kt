package pages

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.espressotemplate.R
import com.example.espressotemplate.ToastMatcher

class LoginPage {

    private val loginInput = withId(R.id.username)
    private val passwordInput = withId(R.id.password)
    private val loginButton = withId(R.id.login)

    fun assertPageIsDisplayed() {
        loginInput.matches(isDisplayed())
        passwordInput.matches(isDisplayed())
        loginButton.matches(isDisplayed())
    }

    fun enterLoginText(login: String) = apply {
        onView(loginInput).perform(typeText(login))
    }

    fun enterPasswordText(password: String) = apply {
        onView(passwordInput).perform(typeText(password))
    }

    fun clickOnPasswordInput() = apply {
        onView(passwordInput).perform(click())
    }

    fun clickLoginButton() = apply {
        onView(loginButton).perform(click())
    }

    fun closeKeyboard() = apply {
        Espresso.closeSoftKeyboard()
    }

    // TODO: fix toast assertion
    fun assertToastIsDisplayed(toastText: String) {
        onView(ViewMatchers.withText(toastText))
            .inRoot(ToastMatcher())
            .check(matches(isDisplayed()))
    }

    fun assertErrorMessageIsDisplayed(errorText: String) {
        onView(passwordInput).check(matches(ViewMatchers.hasErrorText(errorText)))
    }
}

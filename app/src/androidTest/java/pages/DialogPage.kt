package pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.espressotemplate.R

class DialogPage {

    private val launchDialogButton = withId(R.id.button_launch_dialog)
    private val dialogInput = withId(R.id.md_input_message)
    private val okButton = withText(R.string.text_ok)
    private val textName = withId(R.id.text_name)

    // Click on dialog button
    fun clickDialogButton() = apply {
        onView(launchDialogButton).perform(click())
    }

    // Enter text in dialog input
    fun enterName(name: String) = apply {
        onView(dialogInput).perform(typeText(name))
    }

    // Click OK
    fun clickOk() = apply {
        onView(okButton).perform(click())
    }

    // Check if dialog is closed
    fun assertDialogIsClosed() = apply {
        onView(withText(R.string.text_enter_name)).check(doesNotExist())
    }

    // Check if expected name is displayed
    fun assertNameIsDisplayed(expectedName: String) = apply {
        onView(textName).check(matches(withText(expectedName)))
    }
}
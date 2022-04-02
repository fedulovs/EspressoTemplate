package com.example.espressotemplate

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import androidx.test.InstrumentationRegistry
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.espressotemplate.matchers.DrawableMatcher.hasDrawable
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class CameraActivitySuite {

    @get: Rule
    val intentsTestRule = IntentsTestRule(CameraActivity::class.java)

    @Test
    fun checkCameraIntent() {

        // Given
        val activityResult = createImageCaptureActivityResultStub()
        val expectedIntent: Matcher<Intent> = hasAction(MediaStore.ACTION_IMAGE_CAPTURE)
        intending(expectedIntent).respondWith(activityResult)

        // Execute and verify
        onView(withId(R.id.image_from_camera)).check(matches(not(hasDrawable())))
        onView(withId(R.id.button_open_camera)).perform(click())
        intending(expectedIntent)
        onView(withId(R.id.image_from_camera)).check(matches(hasDrawable()))
    }

    private fun createImageCaptureActivityResultStub(): ActivityResult? {
        val bundle = Bundle()
        bundle.putParcelable(
            KEY_IMAGE_DATA,
            BitmapFactory.decodeResource(
                InstrumentationRegistry.getInstrumentation().targetContext.resources,
                R.drawable.ic_launcher_background
            )
        )
        val resultData = Intent()
        resultData.putExtras(bundle)
        return ActivityResult(Activity.RESULT_OK, resultData)
    }
}
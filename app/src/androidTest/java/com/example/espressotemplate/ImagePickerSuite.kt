package com.example.espressotemplate

import android.app.Activity.RESULT_OK
import android.app.Instrumentation.ActivityResult
import android.content.ContentResolver
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasData
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ImagePickerSuite {

    @get: Rule
    val intentsTestRule = IntentsTestRule(GalleryPickerActivity::class.java)

    @Test
    fun validateGalleryIntent() {

        val expectedIntent: Matcher<Intent> = allOf(
            hasAction(Intent.ACTION_PICK),
            hasData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        )

        val activityResult = createGalleryPickActivityResultStub()
        intending(expectedIntent).respondWith(activityResult)

        // Execute and Verify
        onView(withId(R.id.button_open_gallery)).perform(click())
        intended(expectedIntent)
    }

    private fun createGalleryPickActivityResultStub(): ActivityResult {

        val resources = InstrumentationRegistry.getInstrumentation().targetContext.resources
        val imageUri = Uri.parse(
            ContentResolver.SCHEME_ANDROID_RESOURCE +
                    "://" + resources.getResourcePackageName(R.drawable.ic_launcher_background)
                    + '/' + resources.getResourceTypeName(R.drawable.ic_launcher_background)
                    + '/' + resources.getResourceEntryName(R.drawable.ic_launcher_background)
        )

        val resultIntent = Intent()
        resultIntent.setData(imageUri)
        return ActivityResult(RESULT_OK, resultIntent)
    }
}

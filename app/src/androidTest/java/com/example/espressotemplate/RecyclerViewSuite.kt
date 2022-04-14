package com.example.espressotemplate

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RecyclerViewSuite {

    @get: Rule
    val activityRule = ActivityScenarioRule(RecyclerActivity::class.java)

    @Test
    fun clickRecyclerViewItem() {

        // Click on recycler item
        onView(withId(R.id.recycler_view))
            .perform(actionOnItemAtPosition<MyAdapter.MyViewHolder>(8, click()))
    }

    @Test
    fun checkRecyclerViewItemText() {

        // Scroll to item and check it's text
        onView(withId(R.id.recycler_view))
            .perform(scrollToPosition<MyAdapter.MyViewHolder>(8))
            .check(matches(hasDescendant(withText("Heading 9"))))
    }
}
package com.example.espressotemplate

import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.web.sugar.Web.onWebView
import androidx.test.espresso.web.webdriver.DriverAtoms.findElement
import androidx.test.espresso.web.webdriver.DriverAtoms.webClick
import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WebViewTest {
    @get:Rule
    val activityScenarioRule = activityScenarioRule<WebViewActivity>()
    // Activity testrule
    //  1)  launch activity
    //  2)  override afterActivityLaunched()

    @Override
    fun afterActivityLaunched() {
        onWebView(withId(R.id.web_view)).forceJavascriptEnabled()
    }

//    @Before
//    fun setUp() {
//        // Open login activity
//        // ActivityScenario.launch(WebViewActivity::class.java)
//    }

    @Test
    fun searchTest() {
        activityScenarioRule
            .scenario
            .onActivity { activity ->
                onWebView(withId(R.id.web_view)).forceJavascriptEnabled()
            }


        onWebView()
            .withElement(
                findElement(
                    Locator.CSS_SELECTOR,
                    "name=q"
                )
            ) // similar to onView(withId(...))
            .perform(webClick()) // Similar to perform(click())

        // Similar to check(matches(...))
//            .check(webMatches(getCurrentUrl(), containsString("navigation_2.html")))
    }
}
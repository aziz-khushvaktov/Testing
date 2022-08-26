package com.example.testing.activity

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.testing.R
import com.example.testing.utils.Utils
import org.hamcrest.core.StringContains.containsString
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginActivityTest {
    private lateinit var scenario: ActivityScenario<LoginActivity>

    @Before
    fun setup() {
        scenario = launchActivity()
        scenario.moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun loginWithValidCredentials() {
        onView(withId(R.id.et_email)).perform(typeText(Utils.EMAIL),ViewActions.closeSoftKeyboard())

        onView(withId(R.id.et_password)).perform(typeText(Utils.PASSWORD),ViewActions.closeSoftKeyboard())

        onView(withId(R.id.b_logIn)).perform(ViewActions.click())

        onView(withId(R.id.tv_message)).check(matches(withText(containsString(Utils.EMAIL))))
    }
}
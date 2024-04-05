package com.example.myhisapplication

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun generateButton_Click_DisplayPerson() {
        // Instantiate MainActivity
        val scenario = androidx.test.core.app.ActivityScenario.launch(MainActivity::class.java)

        // Input an age and click generateButton
        Espresso.onView(ViewMatchers.withId(R.id.age_input))
            .perform(ViewActions.typeText("40"), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.generate_button)).perform(ViewActions.click())

        // Check if feedbackTextView displays the correct person
        Espresso.onView(ViewMatchers.withId(R.id.text_view))
            .check(ViewAssertions.matches(ViewMatchers.withText("A famous person who passed away at the age of 40 was Edgar Allan Poe.")))

        // Close the activity after test
        scenario.close()
    }

    @Test
    fun generateButton_Click_EmptyAge_ShowError() {
        // Instantiate MainActivity
        val scenario = androidx.test.core.app.ActivityScenario.launch(MainActivity::class.java)

        // Click generateButton without inputting age
        Espresso.onView(ViewMatchers.withId(R.id.generate_button)).perform(ViewActions.click())

        // Check if an error dialog appears
        Espresso.onView(ViewMatchers.withText("Please enter an age."))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        // Close the activity after test
        scenario.close()
    }

    // Add more test cases for different scenarios
}

package com.javajj.lushTechTest.view.fragment

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.javajj.lushTechTest.R
import com.javajj.lushTechTest.view.adapter.RocketViewHolder
import org.junit.Before


import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {

    @Before
    fun setup(){
        launchFragmentInContainer(Bundle(), R.style.Theme_AppCompat) {
            HomeFragment()
        }
    }

    @Test
    fun test_isRecyclerViewVisible(){
        onView(
            withId(R.id.rocket_recyclerview)
        ).check(matches(isDisplayed()))
    }

    @Test
    fun doesRecyclerViewHaveData(){
        onView(
            withId(R.id.rocket_recyclerview)
        ).perform(
            actionOnItemAtPosition<RocketViewHolder>(0, click())
        )
    }
}
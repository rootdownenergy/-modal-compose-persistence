package com.example.lulu.presentation.garments_list

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lulu.di.TestAppModule
import com.example.lulu.presentation.MainActivity
import com.example.lulu.presentation.garments_list.components.ModalBottomSheetLayoutScreen
import com.example.lulu.presentation.util.TestTags
import com.example.lulu.presentation.util.theme.LuluTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@HiltAndroidTest
@UninstallModules(TestAppModule::class)
class GarmentsListScreenTest {
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)
    // simulate a screen
    @ExperimentalAnimationApi
    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()


    @ExperimentalAnimationApi
    @Before
    fun setup(){
        hiltRule.inject()
        //set up the screen
        composeRule.setContent {
            // still want to wrap around a nav obj
            val navControlller = rememberNavController()
            LuluTheme {
                ModalBottomSheetLayoutScreen()
            }
        }
    }

    @ExperimentalAnimationApi
    @Test
    fun clickToggleOrderSection_isVisible() {
        // find composable orderSection
        // find that not initially on screen
        composeRule.onNodeWithTag(TestTags.ORDER_SECTION).assertDoesNotExist()
        // now click on the order icon button
        composeRule.onNodeWithContentDescription("Sort").performClick()
        //assert that the order section is visible after performing the click
        composeRule.onNodeWithTag(TestTags.ORDER_SECTION).assertIsDisplayed()
    }
}
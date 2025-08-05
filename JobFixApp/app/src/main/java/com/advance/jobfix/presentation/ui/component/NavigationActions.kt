package com.advance.jobfix.presentation.ui.component

import android.util.Log
import androidx.navigation.NavController

object JobfitDestination {
    const val HOME_ROUTE = "home"
    const val ABOUT_ME_ROUTE = "about me"
    const val ALGORITHM_ROUTE = "algorithm"
}

class NavigationActions(navController: NavController) {

    private val TAG = NavigationActions::class.java.simpleName

    val navigateToHome: () -> Unit = {
        Log.d(TAG, "navigate to home page.")
        navController.navigate(JobfitDestination.HOME_ROUTE) {
            //TODO: Update later
        }
    }

    val navigateToAboutMe: () -> Unit = {
        Log.d(TAG, "navigate to about me page.")
        navController.navigate(JobfitDestination.ABOUT_ME_ROUTE) {
            //TODO: Update later
        }
    }

    val navigateToAlgorithm: () -> Unit = {
        Log.d(TAG, "navigate to algorithm")
        navController.navigate(JobfitDestination.ALGORITHM_ROUTE) {
            //TODO: Update later
        }
    }
}
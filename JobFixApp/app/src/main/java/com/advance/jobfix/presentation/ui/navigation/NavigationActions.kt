package com.advance.jobfix.presentation.ui.navigation

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

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
            Log.d(TAG, "navigate to HOME_ROUTE")
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    val navigateToAboutMe: () -> Unit = {
        Log.d(TAG, "navigate to about me page.")
        navController.navigate(JobfitDestination.ABOUT_ME_ROUTE) {
            Log.d(TAG, "navigate to ABOUT_ME_ROUTE")
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    val navigateToAlgorithm: () -> Unit = {
        Log.d(TAG, "navigate to algorithm")
        navController.navigate(JobfitDestination.ALGORITHM_ROUTE) {
            Log.d(TAG, "navigate to ALGORITHM_ROUTE")
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}
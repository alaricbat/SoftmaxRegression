package com.advance.jobfix.presentation.ui.navigation

import android.app.Activity
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.advance.jobfix.presentation.ui.base.BaseViewModel
import com.advance.jobfix.presentation.ui.page.home.HomeRoute
import com.advance.jobfix.presentation.ui.page.home.HomeViewModel

@Composable
fun NavigationGraph(
    isExpandedScreen: Boolean,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    openDrawer: () -> Unit = {},
    startDestination: String = JobfitDestination.HOME_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        composable(
            route = JobfitDestination.HOME_ROUTE
        ) { navBackStackEntry ->

            val homeViewModel: HomeViewModel = viewModel(
                factory = BaseViewModel.provideFactory { HomeViewModel() }
            )

            HomeRoute(
                homeViewModel = homeViewModel,
                isExpandedScreen = isExpandedScreen,
                openDrawer = openDrawer,
            )

        }
    }
}


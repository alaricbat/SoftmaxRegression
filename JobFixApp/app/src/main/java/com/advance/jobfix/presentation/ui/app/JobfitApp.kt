package com.advance.jobfix.presentation.ui.app

import android.app.Activity
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.advance.jobfix.presentation.ui.navigation.JobfitDestination
import com.advance.jobfix.presentation.ui.navigation.NavigationActions
import com.advance.jobfix.presentation.ui.navigation.NavigationDrawer
import com.advance.jobfix.presentation.ui.navigation.NavigationGraph
import com.advance.jobfix.presentation.ui.state.DrawerState
import com.advance.jobfix.presentation.ui.theme.JobFixTheme
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun JobfitApp(activity: Activity) {
    JobFixTheme {

        val widthSizeClass = calculateWindowSizeClass(activity).widthSizeClass

        val navController =  rememberNavController()
        val navigationActions = remember(navController) {
            NavigationActions(navController)
        }

        val coroutineScope = rememberCoroutineScope()

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute =
            navBackStackEntry?.destination?.route?: JobfitDestination.HOME_ROUTE

        val isExpandedScreen = widthSizeClass == WindowWidthSizeClass.Expanded
        val sizeAwareDrawerState = DrawerState.rememberSizeAwareDrawerState(isExpandedScreen)

        ModalNavigationDrawer(
            drawerContent = {
                NavigationDrawer(
                    drawerState = sizeAwareDrawerState,
                    currentRoute = currentRoute,
                    navigateToHome = navigationActions.navigateToHome,
                    navigateToAboutMe = navigationActions.navigateToAboutMe,
                    navigateToAlgorithm = navigationActions.navigateToAlgorithm,
                    closeDrawer = {
                        coroutineScope.launch {
                            sizeAwareDrawerState.close()
                        }
                    }
                )
            },
            drawerState = sizeAwareDrawerState,
            // Only enable opening the drawer via gestures if the screen is not expanded
            gesturesEnabled = !isExpandedScreen
        ) {
            //Config navigation graph
            //This graph will be used to check id then switching to corresponding layouts.
            NavigationGraph(
                isExpandedScreen = isExpandedScreen,
                navController = navController,
            )
        }


    }
}

@Composable
fun HomeFeedScreen(

){

}

@Preview("Home Screen")
@Composable
fun PreviewHomeScreen() {
    JobFixTheme {

    }
}
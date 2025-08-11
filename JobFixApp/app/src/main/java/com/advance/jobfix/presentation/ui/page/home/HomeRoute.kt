package com.advance.jobfix.presentation.ui.page.home

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun HomeRoute (
    homeViewModel: HomeViewModel,
    isExpandedScreen: Boolean,
    openDrawer: () -> Unit,
    snackbarHostState: SnackbarHostState = remember {
        SnackbarHostState()
    }
) {

    // UiState of the HomeScreen
    //TODO Update Screen State Later.

    //Basically showing Home Screen
    HomeScreen(
        openDrawer = openDrawer
    )

}
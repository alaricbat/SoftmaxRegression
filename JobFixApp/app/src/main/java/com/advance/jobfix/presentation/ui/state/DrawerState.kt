package com.advance.jobfix.presentation.ui.state

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable

object DrawerState {

    @Composable
    fun rememberSizeAwareDrawerState(isExpandedScreen: Boolean): androidx.compose.material3.DrawerState {
        val drawerState = rememberDrawerState(DrawerValue.Closed)

        return if (!isExpandedScreen) {
            drawerState
        } else {
            androidx.compose.material3.DrawerState(DrawerValue.Closed)
        }

    }

}
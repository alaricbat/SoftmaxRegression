package com.advance.jobfix.presentation.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.advance.jobfix.presentation.ui.theme.JobFixTheme


@Composable
fun HomeScreen() {
    JobFixTheme {
        val navController =  rememberNavController()

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
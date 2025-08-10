package com.advance.jobfix.presentation.ui.page.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen() {

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "Home Screen",
        )
    }

}

@Preview("Home screen")
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}
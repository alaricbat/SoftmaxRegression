package com.advance.jobfix

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.advance.jobfix.presentation.ui.base.BaseActivity
import com.advance.jobfix.presentation.ui.home.HomeScreen
import com.advance.jobfix.presentation.ui.theme.JobFixTheme

class MainActivity : BaseActivity() {

    @Composable
    override fun Content() {
        enableEdgeToEdge()
        JobFixTheme {
            HomeScreen()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
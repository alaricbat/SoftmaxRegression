package com.advance.jobfix

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import com.advance.jobfix.presentation.ui.base.BaseActivity
import com.advance.jobfix.presentation.ui.app.JobfitApp
import com.advance.jobfix.presentation.ui.theme.JobFixTheme

class MainActivity : BaseActivity() {

    @Composable
    override fun Content() {
        enableEdgeToEdge()
        JobFixTheme {
            JobfitApp(this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
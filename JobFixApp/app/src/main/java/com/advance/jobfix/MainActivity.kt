package com.advance.jobfix

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.advance.jobfix.presentation.ui.base.BaseActivity
import com.advance.jobfix.presentation.ui.theme.JobFixTheme
import com.advance.jobfix.presentation.ui.theme.WhiteTrafficWhite

class MainActivity : BaseActivity() {

    @Composable
    override fun Content() {
        enableEdgeToEdge()
        JobFixTheme {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                containerColor = WhiteTrafficWhite
            ) { innerPadding ->
                Greeting(
                    name = "Android",
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JobFixTheme {
        Greeting("Android")
    }
}
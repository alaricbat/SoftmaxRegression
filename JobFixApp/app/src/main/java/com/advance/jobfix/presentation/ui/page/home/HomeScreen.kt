package com.advance.jobfix.presentation.ui.page.home

import android.text.InputType
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.TopAppBarState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.advance.jobfix.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    openDrawer: () -> Unit,
//    snackbarHostState: SnackbarHostState,
    modifier: Modifier = Modifier
) {

    val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(topAppBarState)

    Scaffold (
        snackbarHost = {
        },
        topBar = {
            HomeTopAppBar(
                openDrawer = openDrawer,
                topAppBarState = topAppBarState
            )
        },
        modifier = modifier
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = stringResource(R.string.str_app_description).trimIndent(),
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
            )

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(PaddingValues(10.dp)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.width(100.dp),
                    textAlign = TextAlign.Start,
                    text = stringResource(R.string.str_linguistic) + " : ",
                    fontWeight = FontWeight.Bold
                )
                SimpleTextField()
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(PaddingValues(10.dp)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.width(100.dp),
                    textAlign = TextAlign.Start,
                    text = stringResource(R.string.str_musical).trimIndent() + " : ",
                    fontWeight = FontWeight.Bold
                )
                SimpleTextField()
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(PaddingValues(10.dp)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.width(100.dp),
                    textAlign = TextAlign.Start,
                    text = stringResource(R.string.str_bodily).trimIndent(),
                    fontWeight = FontWeight.Bold
                )
                SimpleTextField()
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(PaddingValues(50.dp)),
                onClick = {}
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(R.string.str_get_result).trimIndent(),
                    textAlign = TextAlign.Center
                )
            }

        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeTopAppBar(
    openDrawer: () -> Unit,
    modifier: Modifier = Modifier,
    topAppBarState: TopAppBarState = rememberTopAppBarState(),
    scrollBehavior: TopAppBarScrollBehavior? =
        TopAppBarDefaults.enterAlwaysScrollBehavior(topAppBarState)
) {
    val context = LocalContext.current
    val title = stringResource(id = R.string.app_name)
    CenterAlignedTopAppBar(
        title = {
            Image(
                painter = painterResource(R.drawable.home_title),
                contentDescription = title,
                modifier = Modifier.fillMaxWidth()
            )
        }
    )
}

@Composable
fun SimpleTextField() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp),
        value = text,
        onValueChange = { newText ->
            text = newText
        }
    )
}


@Preview("Home screen")
@Composable
fun PreviewHomeScreen() {
    HomeScreen(
        openDrawer = {},
    )
}
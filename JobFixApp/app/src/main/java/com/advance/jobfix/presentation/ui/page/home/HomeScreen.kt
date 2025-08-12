package com.advance.jobfix.presentation.ui.page.home

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.TopAppBarState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
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
    modifier: Modifier = Modifier,
//    state: LazyListState = rememberLazyListState()
) {

    val focusManager = LocalFocusManager.current
    val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(topAppBarState)

    Scaffold (
        snackbarHost = {
        },
        topBar = {
            HomeTopAppBar(
                openDrawer = openDrawer,
                topAppBarState = topAppBarState,
                scrollBehavior = scrollBehavior
            )
        },
        modifier = modifier
    ) { innerPadding ->

        val contentModifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)

        LazyColumn (
            modifier = contentModifier
                .padding(innerPadding)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                ) {
                    focusManager.clearFocus()
                },
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {

            val linguisticText = mutableStateOf(TextFieldValue(""))
            val musicalText = mutableStateOf(TextFieldValue(""))
            val bodilyText = mutableStateOf(TextFieldValue(""))

            item {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = stringResource(R.string.str_app_description).trimIndent(),
                )
            }

            item {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                )
            }

            item {
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
                    RankTextField(linguisticText)
                }
            }

            item {

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
                    RankTextField(musicalText)
                }
            }

            item {
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
                    RankTextField(bodilyText)
                }

            }

            item {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(PaddingValues(50.dp)),
                    onClick = {
                        val totalRank =
                            linguisticText.value.text + " - " +
                                    musicalText.value.text + " - " +
                                    bodilyText.value.text
                        Log.d("HomeScreen", totalRank)
                    }
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
    val title = stringResource(id = R.string.app_name)
    CenterAlignedTopAppBar(
        title = {
            Image(
                painter = painterResource(R.drawable.home_title),
                contentDescription = title,
                modifier = Modifier.fillMaxWidth()
            )
        },
        scrollBehavior = scrollBehavior
    )
}

@Composable
fun RankTextField(value: MutableState<TextFieldValue>) {

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp),
        maxLines = 1,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        value = value.value,
        onValueChange = { newText ->
            value.value = newText
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
package com.advance.jobfix.presentation.ui.navigation

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.advance.jobfix.R
import com.advance.jobfix.presentation.ui.theme.GraphiteBlack
import com.advance.jobfix.presentation.ui.theme.JobFixTheme
import com.advance.jobfix.presentation.ui.theme.WhiteTrafficWhite

@Composable
fun NavigationDrawer(
    drawerState: DrawerState,
    currentRoute: String,
    navigateToHome: () -> Unit,
    navigateToAboutMe: () -> Unit,
    navigateToAlgorithm: () -> Unit,
    closeDrawer: () -> Unit,
    modifier: Modifier = Modifier
) {

    val itemCornerRadius = 5.dp

    ModalDrawerSheet(
        drawerState = drawerState,
        modifier = modifier
    ) {
        JobfitLogo(
            modifier = modifier
        )
        Spacer(
            modifier.padding(
                PaddingValues(5.dp)
            )
        )
        NavigationDrawerItem(
            label = {
                Text(
                    text = stringResource(R.string.str_home)
                )
            },
            selected = currentRoute == JobfitDestination.HOME_ROUTE,
            onClick = {
                Log.d("AppDrawer", "navigate to [Home]")
                navigateToHome()
                closeDrawer()
            },
            shape = RoundedCornerShape(itemCornerRadius),
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )
        NavigationDrawerItem(
            label = {
                Text(
                    text = stringResource(R.string.str_about_me)
                )
            },
            selected = currentRoute == JobfitDestination.ABOUT_ME_ROUTE,
            onClick = {
                Log.d("AppDrawer", "navigate to [About me]")
                navigateToAboutMe()
                closeDrawer()
            },
            shape = RoundedCornerShape(itemCornerRadius),
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )
        NavigationDrawerItem(
            label = {
                Text(
                    text = stringResource(R.string.str_algorithm)
                )
            },
            selected = currentRoute == JobfitDestination.ALGORITHM_ROUTE,
            onClick = {
                Log.d("AppDrawer", "navigate to [Algorithm]")
                navigateToAlgorithm()
                closeDrawer()
            },
            shape = RoundedCornerShape(itemCornerRadius),
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )
    }
}

@Composable
private fun JobfitLogo(modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(GraphiteBlack),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(
                id = R.string.str_jobfit_menus
            ),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = WhiteTrafficWhite
        )
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = modifier
                    .padding(
                        paddingValues = PaddingValues(10.dp)
                    )
                    .size(35.dp),
                painter = painterResource(R.drawable.ic_jobfit_background_filled),
                contentDescription = null,
            )
        }
    }
    HorizontalDivider()
}


@Preview("Drawer content of navigation")
@Composable
fun PreviewAppDrawer() {
    JobFixTheme {
        NavigationDrawer(
            drawerState = rememberDrawerState(initialValue = DrawerValue.Open),
            currentRoute = JobfitDestination.HOME_ROUTE,
            navigateToHome = {},
            navigateToAboutMe = {},
            navigateToAlgorithm = {},
            closeDrawer = {},
        )
    }
}
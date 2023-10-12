package com.rodrigoguerrero.myweather.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.khalid.prepaid.ui.screens.SplashScreen
import com.khalid.prepaid.ui.screens.TermsAndConditionScreen
import com.rodrigoguerrero.myweather.ui.screens.MainScreen
import com.rodrigoguerrero.myweather.ui.screens.SearchScreen
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.rememberNavigator

@Composable
fun RootNavGraph(navigator: Navigator = rememberNavigator()) {
    NavHost(
        navigator = navigator,
        initialRoute = "/splash",
    ) {
        scene("/splash") {
            SplashScreen(
                onNavigateNext = { navigator.navigate("/termsAndConditions") },
            )
        }
        scene("/termsAndConditions") {
            TermsAndConditionScreen(
                onNavigateToSearch = { navigator.navigate("/home") },
            )
        }
        scene("/home") {
            MainScreen(
                modifier = Modifier.fillMaxSize(),
                onNavigateToSearch = { navigator.navigate("/search") },
            )
        }
        scene("/search") {
            SearchScreen(
                modifier = Modifier.fillMaxSize(),
                onClose = { navigator.popBackStack() }
            )
        }
    }
}

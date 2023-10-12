package com.khalid.prepaid.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.khalid.prepaid.ui.screens.AccountScreen
import com.khalid.prepaid.ui.screens.CommonErrorScreen
import com.khalid.prepaid.ui.screens.CommonWebViewScreen
import com.khalid.prepaid.ui.screens.HomeScreen
import com.khalid.prepaid.ui.screens.IDDInfoScreen
import com.khalid.prepaid.ui.screens.LoginScreen
import com.khalid.prepaid.ui.screens.OTPScreen
import com.khalid.prepaid.ui.screens.PlanDetailsScreen
import com.khalid.prepaid.ui.screens.ReviewOrderScreen
import com.khalid.prepaid.ui.screens.RoamingTipsScreen
import com.khalid.prepaid.ui.screens.SplashScreen
import com.khalid.prepaid.ui.screens.TermsAndConditionScreen
import com.khalid.prepaid.ui.screens.TopUpListScreen
import com.khalid.prepaid.ui.screens.UsageDetailsScreen
import com.khalid.prepaid.ui.screens.WalletScreen
import com.rodrigoguerrero.myweather.ui.screens.MainScreen
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.rememberNavigator


@Composable
fun prepaidNavigationGraph(navigator: Navigator = rememberNavigator()){
    NavHost(
        navigator = navigator,
        initialRoute = "/splash",
    ) {
        scene("/account") {
            AccountScreen(
                onNavigateToSearch = { navigator.navigate("/account") },
                modifier = Modifier.fillMaxSize())
        }
        scene("/error") {
            CommonErrorScreen(
                onNavigateToSearch = { navigator.navigate("/account") },
                modifier = Modifier.fillMaxSize())
        }
        scene("/webView") {
            CommonWebViewScreen(
                onNavigateToSearch = { navigator.navigate("/account") },
                modifier = Modifier.fillMaxSize())
        }
        scene("/home") {
            HomeScreen(
                onNavigateToSearch = { navigator.navigate("/home") },
                modifier = Modifier.fillMaxSize())
        }
        scene("/iddInfo") {
            IDDInfoScreen(
                onNavigateToSearch = { navigator.navigate("/home") },
                modifier = Modifier.fillMaxSize())
        }
        scene("/login") {
            LoginScreen(
                onNavigateToOtp = { navigator.navigate("/otp") },
                modifier = Modifier.fillMaxSize())
        }
        scene("/main") {
            MainScreen(
                onNavigateToSearch = { navigator.navigate("/main") },
                modifier = Modifier.fillMaxSize())
        }
        scene("/otp") {
            OTPScreen(
                onNavigateToMain = { navigator.navigate("/home") },
                onNavigateToError = { navigator.navigate("/error") },
                modifier = Modifier.fillMaxSize())
        }
        scene("/planDetail") {
            PlanDetailsScreen(
                onNavigateToSearch = { navigator.navigate("/account") },
                modifier = Modifier.fillMaxSize())
        }
        scene("/reviewDetails") {
            ReviewOrderScreen(
                onNavigateToSearch = { navigator.navigate("/account") },
                modifier = Modifier.fillMaxSize())
        }
        scene("/roamingTips") {
            RoamingTipsScreen(
                onNavigateToSearch = { navigator.navigate("/account") },
                modifier = Modifier.fillMaxSize())
        }
        scene("/splash") {
            SplashScreen(
                onNavigateNext = { navigator.navigate("/search") },
            )
        }
        scene("/termsAndConditions") {
            TermsAndConditionScreen(
                onNavigateToSearch = { navigator.navigate("/search") },
            )
        }
        scene("/topup") {
            TopUpListScreen(
                onNavigateToSearch = { navigator.navigate("/home") },
                modifier = Modifier.fillMaxSize())
        }
        scene("/usageDetails") {
            UsageDetailsScreen(
                onNavigateToSearch = { navigator.navigate("/account") },
                modifier = Modifier.fillMaxSize())
        }
        scene("/walletScreen") {
            WalletScreen(
                onNavigateToSearch = { navigator.navigate("/walletScreen") },
                modifier = Modifier.fillMaxSize())
        }
    }
}

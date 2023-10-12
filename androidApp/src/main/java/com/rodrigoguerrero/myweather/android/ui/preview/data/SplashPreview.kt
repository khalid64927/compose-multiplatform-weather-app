package com.rodrigoguerrero.myweather.android.ui.preview.data

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.khalid.prepaid.ui.screens.SplashScreen


@Preview
@Composable
fun splashComposablePreview(){
    SplashScreen(onNavigateNext = { /*no-op*/ })
}


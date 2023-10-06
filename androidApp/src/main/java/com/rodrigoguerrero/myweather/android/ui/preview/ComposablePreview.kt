package com.rodrigoguerrero.myweather.android.ui.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.myweather.android.ui.preview.data.todayWeatherUiState
import com.rodrigoguerrero.myweather.ui.components.CurrentDateItem
import com.rodrigoguerrero.myweather.ui.components.CurrentDetailsItem
import com.rodrigoguerrero.myweather.ui.components.CurrentWeatherItem
import com.rodrigoguerrero.myweather.ui.screens.CurrentWeatherScreenContentForPreview
import com.rodrigoguerrero.myweather.ui.theme.AppTheme


@Preview
@Composable
fun CurrentDateItemPreview(){
    AppTheme(darkTheme = false, dynamicColor = false) {
        CurrentDateItem("10:30")
    }
}

@Preview
@Composable
fun CurrentDetailsItemPreview(){
    AppTheme(darkTheme = false, dynamicColor = false) {
        CurrentDetailsItem(todayWeatherUiState)
    }
}

@Preview
@Composable
fun CurrentWeatherItemPreview(){
    AppTheme(darkTheme = false, dynamicColor = false) {
        CurrentWeatherItem(todayWeatherUiState)
    }
}

@Preview
@Composable
fun CurrentWeatherScreenContentPreview(){
    AppTheme(darkTheme = false, dynamicColor = false) {
        CurrentWeatherScreenContentForPreview(todayWeatherUiState)
    }

}
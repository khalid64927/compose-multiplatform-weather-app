package com.rodrigoguerrero.myweather.android.ui.preview.data


import androidx.compose.runtime.Composable

import androidx.compose.ui.tooling.preview.Preview
import com.khalid.prepaid.ui.screens.TermsAndConditionScreen

@Preview
@Composable
fun TermsAndConditionsComposablePreview() {
    //SimpleScaffoldWithTopBar()
     TermsAndConditionScreen(onNavigateToSearch = { /*no-op*/ })
}
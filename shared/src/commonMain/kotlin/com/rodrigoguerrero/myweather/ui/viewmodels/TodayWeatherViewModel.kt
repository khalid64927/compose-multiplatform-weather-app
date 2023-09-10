package com.rodrigoguerrero.myweather.ui.viewmodels

import com.rodrigoguerrero.myweather.common.BaseViewModel
import com.rodrigoguerrero.myweather.ui.models.events.TodayWeatherEvent
import com.rodrigoguerrero.myweather.ui.models.uistate.TodayWeatherUiState
import com.rodrigoguerrero.myweather.ui.models.uistate.isError
import com.rodrigoguerrero.myweather.ui.models.uistate.isLoading
import com.rodrigoguerrero.myweather.ui.models.uistate.setResponse
import com.rodrigoguerrero.myweather.ui.models.uistate.updateQuery
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TodayWeatherViewModel : BaseViewModel() {

    private val _state = MutableStateFlow(TodayWeatherUiState())
    val state = _state.asStateFlow()

    fun onEvent(event: TodayWeatherEvent) {
        when (event) {
            is TodayWeatherEvent.UpdateQuery -> _state.updateQuery(event.query)
            TodayWeatherEvent.ShowError -> _state.isError()
            TodayWeatherEvent.ShowLoading -> _state.isLoading()
            is TodayWeatherEvent.UpdateForecast -> {
                event.forecast?.let { forecast ->
                    _state.setResponse(forecast)
                }
            }
        }
    }
}

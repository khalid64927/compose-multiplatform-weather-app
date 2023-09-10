package com.rodrigoguerrero.myweather.ui.viewmodels

import com.rodrigoguerrero.myweather.common.BaseViewModel
import com.rodrigoguerrero.myweather.data.local.datastore.PreferencesRepository
import com.rodrigoguerrero.myweather.domain.interactors.search.DeleteFavoriteLocationInteractor
import com.rodrigoguerrero.myweather.domain.interactors.search.RetrieveFavoriteLocationsInteractor
import com.rodrigoguerrero.myweather.domain.interactors.search.SearchInteractor
import com.rodrigoguerrero.myweather.domain.models.ResourceResult
import com.rodrigoguerrero.myweather.ui.models.uimodels.FavoriteLocation
import com.rodrigoguerrero.myweather.ui.models.events.SearchEvent
import com.rodrigoguerrero.myweather.ui.models.uistate.SearchUiState
import com.rodrigoguerrero.myweather.ui.models.uistate.toUi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.update
import org.koin.core.component.get

@OptIn(FlowPreview::class)
class SearchViewModel : BaseViewModel() {

    private val searchInteractor: SearchInteractor = get()
    private val preferencesRepository: PreferencesRepository = get()
    private val retrieveFavoriteLocationsInteractor: RetrieveFavoriteLocationsInteractor = get()
    private val deleteFavoriteLocationInteractor: DeleteFavoriteLocationInteractor = get()

    private val _state = MutableStateFlow(SearchUiState())
    val state: StateFlow<SearchUiState> = _state.asStateFlow()

    private val search = MutableStateFlow<String?>(null)

    init {
        launchAsync {
            search
                .filterNotNull()
                .distinctUntilChanged()
                .debounce(300)
                .collectLatest { query ->
                    searchInteractor(query).collectLatest { result ->
                        when (result) {
                            is ResourceResult.Error -> onEvent(SearchEvent.ShowError)
                            ResourceResult.Loading -> onEvent(SearchEvent.ShowLoading)
                            is ResourceResult.Success -> onEvent(SearchEvent.ShowSuggestions(result.data))
                        }
                    }
                }
        }

        launchAsync {
            retrieveFavoriteLocationsInteractor()
                .collectLatest { favoriteLocations ->
                    onEvent(
                        SearchEvent.FavoriteLocationsRetrieved(
                            favoriteLocations.map {
                                FavoriteLocation(
                                    id = it.id,
                                    location = it.location,
                                )
                            }
                        )
                    )
                }
        }
    }

    fun onEvent(event: SearchEvent) {
        when (event) {
            is SearchEvent.QueryUpdated -> {
                _state.update { it.copy(query = event.query) }
                search.update { event.query }
            }

            SearchEvent.ShowError -> _state.update { it.copy(isError = true, isLoading = false) }
            SearchEvent.ShowLoading -> _state.update { it.copy(isLoading = true, isError = false) }
            is SearchEvent.ShowSuggestions -> _state.update {
                it.copy(
                    isError = false,
                    isLoading = false,
                    searchSuggestions = event.suggestions.map { suggestion -> suggestion.toUi() },
                )
            }

            is SearchEvent.SuggestionSelected -> {
                saveLocation(event.suggestion.toString())
                onEvent(SearchEvent.OnCompleted)
            }

            SearchEvent.OnCompleted -> _state.update { it.copy(isCompleted = true) }
            is SearchEvent.FavoriteLocationsRetrieved -> _state.update {
                it.copy(favoriteLocations = event.favoriteLocations)
            }

            is SearchEvent.OnFavoriteSelected -> {
                saveLocation(event.location.location)
                onEvent(SearchEvent.OnCompleted)
            }

            SearchEvent.OnManageFavoriteLocations -> _state.update { it.copy(showRemoveFavoritesIcon = !it.showRemoveFavoritesIcon) }
            is SearchEvent.RemoveFavoriteLocation -> deleteLocation(event.location)
            SearchEvent.ClearQuery -> {
                _state.update { it.copy(query = "", searchSuggestions = emptyList()) }
                search.update { "" }
            }
        }
    }

    private fun saveLocation(location: String) {
        launchAsync {
            preferencesRepository.saveLocation(location)
        }
    }

    private fun deleteLocation(favoriteLocation: FavoriteLocation) {
        launchAsync {
            deleteFavoriteLocationInteractor(favoriteLocation)
        }
    }
}

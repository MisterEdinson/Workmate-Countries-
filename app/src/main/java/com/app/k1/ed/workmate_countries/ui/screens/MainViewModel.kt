package com.app.k1.ed.workmate_countries.ui.screens

import android.content.Context
import com.app.k1.ed.workmate_countries.R
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.k1.ed.workmate_countries.core.RequestResult
import com.app.k1.ed.workmate_countries.data.local.entity.CountryEntity
import com.app.k1.ed.workmate_countries.domain.DataRepository
import com.app.k1.ed.workmate_countries.ui.screens.listcountry.state.ListCountriesEvent
import com.app.k1.ed.workmate_countries.ui.screens.listcountry.state.ListCountriesState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repo: DataRepository
) : ViewModel() {
    private val _status = MutableStateFlow<ListCountriesState>(ListCountriesState.Ready)
    val status: StateFlow<ListCountriesState> = _status

    val countries: StateFlow<List<CountryEntity>> = repo.getCountriesAllLocal().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )
    private val _selectCountry = MutableStateFlow(0)
    val selectCountry: StateFlow<Int> = _selectCountry

    init {
        getCountriesApi()
    }

    fun onNewIntent(intent: ListCountriesEvent) {
        when (intent) {
            is ListCountriesEvent.OnClickCountry -> _selectCountry.value = intent.id
        }
    }

    private fun getCountriesApi() {
        _status.value = ListCountriesState.Loading
        viewModelScope.launch {
            when (val result = repo.getCountriesAllNetwork()) {
                is RequestResult.Error -> {
                    _status.value = ListCountriesState.Error(context.getString(R.string.err_internet))
                    delay(200)
                    _status.value = ListCountriesState.Ready
                }

                is RequestResult.Success -> {
                    _status.value = ListCountriesState.Success
                    _status.value = ListCountriesState.Ready
                }
            }
        }
    }
}
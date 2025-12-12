package com.app.k1.ed.workmate_countries.ui.screens.listcountry.state

sealed class ListCountriesState {
    data object Ready : ListCountriesState()
    data object Loading : ListCountriesState()
    data class Error(val error: String) : ListCountriesState()
    data object Success : ListCountriesState()
}
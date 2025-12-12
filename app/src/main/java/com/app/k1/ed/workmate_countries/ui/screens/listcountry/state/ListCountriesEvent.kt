package com.app.k1.ed.workmate_countries.ui.screens.listcountry.state

sealed class ListCountriesEvent {
    data class OnClickCountry(val id: Int) : ListCountriesEvent()
}
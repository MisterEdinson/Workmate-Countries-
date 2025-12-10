package com.app.k1.ed.workmate_countries.ui.navigation

open class Screens (
    val route: String
){
    object ListCountryScreen : Screens(
        route = "list_country_screen"
    )
    object DetailsCountryScreen : Screens(
        route = "details_country_screen"
    )
}
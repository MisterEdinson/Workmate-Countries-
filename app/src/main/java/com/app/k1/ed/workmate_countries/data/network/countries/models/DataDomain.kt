package com.app.k1.ed.workmate_countries.data.network.countries.models

data class CountryResponse(
    val flags: Flags?,
    val name: Name?,
    val currencies: Map<String, Currency>?,
    val capital: List<String>?,
    val region: String?,
    val area: Double?,
    val population: Long?,
    val timezones: List<String>?,
    val continents: List<String>?
)

data class Flags(
    val png: String?,
    val svg: String?,
    val alt: String?
)

data class Name(
    val common: String?,
    val official: String?,
    val nativeName: Map<String, NativeName>?
)

data class NativeName(
    val official: String?,
    val common: String?
)

data class Currency(
    val name: String?,
    val symbol: String?
)
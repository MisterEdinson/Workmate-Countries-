package com.app.k1.ed.workmate_countries.core

import com.app.k1.ed.workmate_countries.data.local.entity.CountryEntity
import com.app.k1.ed.workmate_countries.data.network.countries.models.CountryResponse

fun CountryResponse.toEntity(): CountryEntity {
    val currenciesString = currencies?.values
        ?.mapNotNull { it.name }
        ?.joinToString(",") ?: ""

    return CountryEntity(
        name = name?.common ?: "Unknown",
        flagPng = flags?.png,
        flagSvg = flags?.svg,
        capital = capital?.firstOrNull(),
        region = region,
        area = area?.toLong(),
        population = population,
        timezones = timezones?.joinToString(","),
        continents = continents?.joinToString(","),
        currencies = currenciesString
    )
}


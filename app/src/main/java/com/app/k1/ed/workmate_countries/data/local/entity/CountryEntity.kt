package com.app.k1.ed.workmate_countries.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "countries")
data class CountryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val flagPng: String?,
    val flagSvg: String?,
    val capital: String?,
    val region: String?,
    val area: Long?,
    val population: Long?,
    val timezones: String?,
    val continents: String?,
    val currencies: String?
)
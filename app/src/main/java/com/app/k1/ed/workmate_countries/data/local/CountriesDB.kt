package com.app.k1.ed.workmate_countries.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.k1.ed.workmate_countries.data.local.dao.CountryDao
import com.app.k1.ed.workmate_countries.data.local.entity.CountryEntity

@Database(
    entities = [CountryEntity::class],
    version = 1,
    exportSchema = false
)
abstract class CountriesDB : RoomDatabase() {
    abstract fun countryDao(): CountryDao
}
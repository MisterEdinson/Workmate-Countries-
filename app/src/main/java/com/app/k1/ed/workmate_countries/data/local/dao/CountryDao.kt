package com.app.k1.ed.workmate_countries.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.k1.ed.workmate_countries.data.local.entity.CountryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryDao {

    @Query("SELECT * FROM countries ORDER BY name ASC")
    fun getCountriesFlow(): Flow<List<CountryEntity>>

    @Query("SELECT * FROM countries ORDER BY name ASC")
    suspend fun getCountries(): List<CountryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<CountryEntity>)

    @Query("DELETE FROM countries")
    suspend fun clearAll()
}
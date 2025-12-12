package com.app.k1.ed.workmate_countries.domain

import com.app.k1.ed.workmate_countries.core.RequestResult
import com.app.k1.ed.workmate_countries.data.local.entity.CountryEntity
import com.app.k1.ed.workmate_countries.data.network.countries.models.CountryResponse
import kotlinx.coroutines.flow.Flow

interface DataRepository {
    fun getCountriesAllLocal(): Flow<List<CountryEntity>>
    suspend fun getCountriesAllNetwork(): RequestResult<Unit>
    suspend fun getCountriesLocal(): List<CountryEntity>
}
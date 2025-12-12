package com.app.k1.ed.workmate_countries.domain

import com.app.k1.ed.workmate_countries.core.RequestResult
import com.app.k1.ed.workmate_countries.core.toEntity
import com.app.k1.ed.workmate_countries.data.local.dao.CountryDao
import com.app.k1.ed.workmate_countries.data.local.entity.CountryEntity
import com.app.k1.ed.workmate_countries.data.network.countries.NetworkApi
import com.app.k1.ed.workmate_countries.data.network.countries.models.CountryResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(
    private val api: NetworkApi,
    private val db: CountryDao
) : DataRepository {
    override fun getCountriesAllLocal(): Flow<List<CountryEntity>> = db.getCountriesFlow()
    override suspend fun getCountriesAllNetwork(): RequestResult<Unit> =
        try {
            val data = api.getCountries()
            db.clearAll()
            db.insertAll(data.map { it.toEntity() })
            RequestResult.Success(Unit)
        } catch (e: Exception) {
            RequestResult.Error(e.message ?: "")
        }

    override suspend fun getCountriesLocal(): List<CountryEntity> {
        return db.getCountries()
    }
}
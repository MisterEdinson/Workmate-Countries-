package com.app.k1.ed.workmate_countries.data.network.countries

import com.app.k1.ed.workmate_countries.data.network.countries.models.CountryResponse
import retrofit2.http.GET

interface NetworkApi {
    @GET("app/mobile")
    suspend fun getCountries(): List<CountryResponse>
}
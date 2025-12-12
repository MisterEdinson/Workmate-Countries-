package com.app.k1.ed.workmate_countries.di

import android.content.Context
import androidx.room.Room
import com.app.k1.ed.workmate_countries.data.local.CountriesDB
import com.app.k1.ed.workmate_countries.data.local.dao.CountryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext ctx: Context): CountriesDB =
        Room.databaseBuilder(
            ctx,
            CountriesDB::class.java,
            "countries.db"
        ).build()

    @Provides
    @Singleton
    fun provideCountryDao(db: CountriesDB): CountryDao = db.countryDao()
}
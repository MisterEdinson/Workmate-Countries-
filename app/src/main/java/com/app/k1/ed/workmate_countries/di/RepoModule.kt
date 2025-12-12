package com.app.k1.ed.workmate_countries.di

import com.app.k1.ed.workmate_countries.data.local.dao.CountryDao
import com.app.k1.ed.workmate_countries.data.network.countries.NetworkApi
import com.app.k1.ed.workmate_countries.domain.DataRepository
import com.app.k1.ed.workmate_countries.domain.DataRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepoModule {
    @Provides
    @Singleton
    fun provideDataRepository(
        api: NetworkApi,
        db: CountryDao
    ): DataRepository = DataRepositoryImpl(api, db)
}
package com.example.data.di

import com.example.data.api.NumbersDataStore
import com.example.data.impl.NumbersDataStoreImpl
import com.example.data.impl.repositories.NumberRepositoryImpl
import com.example.domain.repositories.NumberRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal interface DataModule {

    @Singleton
    @Binds
    fun bindNumbersDataStore(dataStore: NumbersDataStoreImpl): NumbersDataStore

    @Singleton
    @Binds
    fun bindNumberRepository(repository: NumberRepositoryImpl): NumberRepository
}


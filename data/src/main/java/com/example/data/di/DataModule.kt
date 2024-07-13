package com.example.data.di

import com.example.data.impl.repositories.NumberRepositoryImpl
import com.example.domain.repositories.NumberRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal interface DataModule {

    @Singleton
    @Binds
    fun bindNumberRepository(repository: NumberRepositoryImpl): NumberRepository
}


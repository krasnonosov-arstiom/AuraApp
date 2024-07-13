package com.example.domain.di

import com.example.domain.usecases.api.GetSavedNumbersStreamUseCase
import com.example.domain.usecases.api.WriteNumberValueUseCase
import com.example.domain.usecases.impl.GetSavedNumbersStreamUseCaseImpl
import com.example.domain.usecases.impl.WriteNumberValueUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
internal interface UseCasesModule {

    @Binds
    fun getSavedNumbersStreamUseCase(useCase: GetSavedNumbersStreamUseCaseImpl): GetSavedNumbersStreamUseCase

    @Binds
    fun writeNumberValueUseCase(useCase: WriteNumberValueUseCaseImpl): WriteNumberValueUseCase
}
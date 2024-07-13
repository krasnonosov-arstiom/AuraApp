package com.example.domain.di

import com.example.domain.usecases.api.GetSavedNumbersStreamUseCase
import com.example.domain.usecases.api.IncrementValueUseCase
import com.example.domain.usecases.api.WriteNumberValueUseCase

interface UseCasesProvider {

    fun getSavedNumbersStreamUseCase(): GetSavedNumbersStreamUseCase
    fun incrementValueUseCase(): IncrementValueUseCase
    fun writeNumberValueUseCase(): WriteNumberValueUseCase
}
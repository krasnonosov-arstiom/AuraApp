package com.example.domain.usecases.api

interface WriteNumberValueUseCase {

    suspend fun invoke(value: Int)
}
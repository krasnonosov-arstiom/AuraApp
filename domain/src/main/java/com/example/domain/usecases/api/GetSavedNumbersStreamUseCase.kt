package com.example.domain.usecases.api

import kotlinx.coroutines.flow.Flow

interface GetSavedNumbersStreamUseCase {

    fun invoke(): Flow<Int>
}
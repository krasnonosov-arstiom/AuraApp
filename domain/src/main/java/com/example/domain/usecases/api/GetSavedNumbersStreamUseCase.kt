package com.example.domain.usecases.api

import com.example.domain.models.BootInfoModel
import kotlinx.coroutines.flow.Flow

interface GetSavedNumbersStreamUseCase {

    fun invoke(): Flow<BootInfoModel>
}
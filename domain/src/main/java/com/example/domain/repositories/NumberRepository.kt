package com.example.domain.repositories

import com.example.domain.models.BootInfoModel
import kotlinx.coroutines.flow.Flow

interface NumberRepository {

    suspend fun writeValue(newBootTime: Long)

    fun getSavedNumbersStream(): Flow<BootInfoModel>
}
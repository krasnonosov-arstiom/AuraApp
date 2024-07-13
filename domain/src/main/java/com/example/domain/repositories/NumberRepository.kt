package com.example.domain.repositories

import kotlinx.coroutines.flow.Flow

interface NumberRepository {

    suspend fun writeValue(value: Int)

    suspend fun incrementValue()

    fun getSavedNumbersStream(): Flow<Int>
}
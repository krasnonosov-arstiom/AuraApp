package com.example.data.api

import kotlinx.coroutines.flow.Flow

interface NumbersDataStore {

    suspend fun writeValue(value: Int)

    suspend fun incrementValue()

    fun getSavedNumbersStream(): Flow<Int>
}
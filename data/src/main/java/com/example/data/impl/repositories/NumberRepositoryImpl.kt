package com.example.data.impl.repositories

import com.example.data.api.NumbersDataStore
import com.example.domain.repositories.NumberRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class NumberRepositoryImpl @Inject constructor(
    private val numbersDataStore: NumbersDataStore,
): NumberRepository {

    override suspend fun writeValue(value: Int) {
        numbersDataStore.writeValue(value)
    }

    override suspend fun incrementValue() {
        numbersDataStore.incrementValue()
    }

    override fun getSavedNumbersStream(): Flow<Int> = numbersDataStore.getSavedNumbersStream()
}
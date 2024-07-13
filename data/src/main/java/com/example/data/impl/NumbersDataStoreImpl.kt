package com.example.data.impl

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import com.example.data.api.NumbersDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class NumbersDataStoreImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>,
) : NumbersDataStore {

    private val numberKey = intPreferencesKey("NUMBER_KEY")

    override suspend fun writeValue(value: Int) {
        dataStore.edit { preferences -> preferences[numberKey] = value }
    }

    override suspend fun incrementValue() {
        dataStore.edit { preferences ->
            val currentValue = preferences[numberKey] ?: 0
            preferences[numberKey] = currentValue + 1
        }
    }

    override fun getSavedNumbersStream(): Flow<Int> = dataStore.data.map { preferences -> preferences[numberKey] ?: 0 }
}
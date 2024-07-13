package com.example.auraapp

import android.app.Application
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.auraapp.di.AppComponent
import com.example.core.AppComponentHolder
import com.example.core.AppComponentProvider
import com.example.data.di.createDataProvider
import com.example.domain.di.createUseCasesProvider

class App: Application(), AppComponentHolder {

    private var _appComponentProvider: AppComponentProvider? = null
    override val appComponentProvider: AppComponentProvider
        get() = checkNotNull(_appComponentProvider) {
            "AppComponentProvider hasn't been initialized"
        }

    private val dataStore: DataStore<Preferences> by preferencesDataStore("AppDataStore")

    override fun onCreate() {
        setUpDi()
        super.onCreate()
    }

    private fun setUpDi() {
        val dataProvider = createDataProvider(dataStore)
        val useCasesProvider = createUseCasesProvider(dataProvider)
        _appComponentProvider = AppComponent.create(useCasesProvider)
    }
}
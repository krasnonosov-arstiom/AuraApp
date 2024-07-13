package com.example.auraapp

import android.app.Application
import android.content.Intent
import android.content.IntentFilter
import com.example.auraapp.di.AppComponent
import com.example.core.AppComponentHolder
import com.example.core.AppComponentProvider
import com.example.data.di.createDataProvider
import com.example.domain.di.createUseCasesProvider
import com.example.feature.eventreciever.EventReceiver

class App : Application(), AppComponentHolder {

    private var _appComponentProvider: AppComponentProvider? = null
    override val appComponentProvider: AppComponentProvider
        get() = checkNotNull(_appComponentProvider) {
            "AppComponentProvider hasn't been initialized"
        }

    override fun onCreate() {
        super.onCreate()
        setUpDi()
    }

    private fun setUpDi() {
        val dataProvider = createDataProvider(applicationContext)
        val useCasesProvider = createUseCasesProvider(dataProvider)
        _appComponentProvider = AppComponent.create(useCasesProvider)
    }
}
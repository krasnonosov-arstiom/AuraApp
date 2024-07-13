package com.example.data.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.domain.di.DataProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class],)
internal interface DataComponent : DataProvider {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance dataStore: DataStore<Preferences>,
        ): DataComponent
    }
}

fun createDataProvider(dataStore: DataStore<Preferences>): DataProvider =
    DaggerDataComponent.factory().create(dataStore)
package com.example.data.di

import android.content.Context
import com.example.domain.di.DataProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class, DatabaseModule::class])
internal interface DataComponent : DataProvider {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance context: Context,
        ): DataComponent
    }
}

fun createDataProvider(context: Context): DataProvider =
    DaggerDataComponent.factory().create(context)
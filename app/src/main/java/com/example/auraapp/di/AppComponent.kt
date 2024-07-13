package com.example.auraapp.di

import com.example.auraapp.App
import com.example.core.AppComponentProvider
import com.example.domain.di.UseCasesProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(dependencies = [UseCasesProvider::class])
interface AppComponent : AppComponentProvider {

    fun inject(app: App)

    @Component.Factory
    interface Factory {

        fun create(
            useCasesProvider: UseCasesProvider,
        ): AppComponent
    }

    companion object {

        fun create(useCasesProvider: UseCasesProvider): AppComponent =
            DaggerAppComponent.factory().create(useCasesProvider)
    }
}
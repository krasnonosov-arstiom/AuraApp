package com.example.domain.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [UseCasesModule::class],
    dependencies = [DataProvider::class]
)
internal interface UseCasesComponent : UseCasesProvider {

    @Component.Factory
    interface Factory {

        fun create(
            dataProvider: DataProvider,
        ): UseCasesComponent
    }
}

fun createUseCasesProvider(dataProvider: DataProvider): UseCasesProvider =
    DaggerUseCasesComponent.factory().create(dataProvider)

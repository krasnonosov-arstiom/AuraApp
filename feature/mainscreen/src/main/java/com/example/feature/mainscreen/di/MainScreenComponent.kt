package com.example.feature.mainscreen.di

import com.example.core.AppComponentProvider
import com.example.feature.mainscreen.MainScreenFragment
import dagger.Component

@Component(
    modules = [ViewModelModule::class],
    dependencies = [AppComponentProvider::class],
)
internal interface MainScreenComponent {

    fun inject(fragment: MainScreenFragment)

    @Component.Factory
    interface Factory {

        fun create(
            appComponentProvider: AppComponentProvider,
        ): MainScreenComponent
    }

    companion object {

        fun create(appComponentProvider: AppComponentProvider): MainScreenComponent =
            DaggerMainScreenComponent.factory().create(appComponentProvider)
    }
}
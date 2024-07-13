package com.example.feature.mainscreen.di

import androidx.lifecycle.ViewModel
import com.example.core.ViewModelKey
import com.example.feature.mainscreen.MainScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainScreenViewModel::class)
    fun bindMainScreenViewModel(viewModelModule: MainScreenViewModel): ViewModel
}
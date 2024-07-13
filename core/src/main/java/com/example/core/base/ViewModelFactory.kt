package com.example.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Reusable
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass

@Reusable
class ViewModelFactory @Inject constructor(
    private val viewModelFactories: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
)  {

    @Suppress("UNCHECKED_CAST")
    fun <VM : ViewModel> create(modelClass: KClass<out ViewModel>): VM {
        val factory = object : ViewModelProvider.Factory {

            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return viewModelFactories[modelClass]?.get() as? T
                    ?: throw IllegalStateException("Unknown view model class $modelClass")
            }
        }
        return factory.create(modelClass.java) as VM
    }
}
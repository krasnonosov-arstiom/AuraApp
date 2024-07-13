package com.example.feature.eventreciever.di

import com.example.core.AppComponentProvider
import com.example.feature.eventreciever.EventReceiver
import dagger.Component

@Component(
    dependencies = [AppComponentProvider::class],
)
interface EventReceiverComponent {

    fun inject(receiver: EventReceiver)

    @Component.Factory
    interface Factory {

        fun create(
            appComponentProvider: AppComponentProvider,
        ): EventReceiverComponent
    }

    companion object {

        fun create(appComponentProvider: AppComponentProvider): EventReceiverComponent =
            DaggerEventReceiverComponent.factory().create(appComponentProvider)
    }
}
package com.example.feature.eventreciever

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.core.AppComponentHolder
import com.example.domain.usecases.api.WriteNumberValueUseCase
import com.example.feature.eventreciever.di.EventReceiverComponent
import dagger.Lazy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

class EventReceiver: BroadcastReceiver(){

    @Inject
    lateinit var writeNumberValueUseCase: Lazy<WriteNumberValueUseCase>

    private val scope: CoroutineScope = CoroutineScope(SupervisorJob())

    override fun onReceive(context: Context?, intent: Intent?) {
        context?.applicationContext?.let { applicationContext ->
            if (applicationContext is AppComponentHolder) {
                EventReceiverComponent.create(applicationContext.appComponentProvider).inject(this)
            }
        }
        if (intent?.action == Intent.ACTION_BOOT_COMPLETED) {
            scope.launch { writeNumberValueUseCase.get().invoke(System.currentTimeMillis()) }
        }
    }
}
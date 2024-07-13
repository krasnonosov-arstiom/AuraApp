package com.example.feature.mainscreen.mappers

import com.example.domain.models.BootInfoModel
import com.example.feature.mainscreen.MainScreenViewModel
import java.text.SimpleDateFormat
import java.util.Date

internal fun BootInfoModel.toMainScreenViewModelState(formatter: SimpleDateFormat): MainScreenViewModel.State =
    when (this) {
        is BootInfoModel.NoValues -> MainScreenViewModel.State.Content("Still no boots")
        is BootInfoModel.LastValue -> {
            val date = Date(time)
            MainScreenViewModel.State.Content("The boot was detected = ${formatter.format(date)}")
        }
        is BootInfoModel.TwoLastValues -> {
            val contentValue = (lastTime - preLastTime) / 1000
            MainScreenViewModel.State.Content("Last boots time delta = $contentValue (in seconds)")
        }
    }

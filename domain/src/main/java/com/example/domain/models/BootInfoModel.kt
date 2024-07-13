package com.example.domain.models

sealed interface BootInfoModel {

    data object NoValues: BootInfoModel
    data class LastValue(val time: Long): BootInfoModel
    data class TwoLastValues(val lastTime: Long, val preLastTime: Long): BootInfoModel
}

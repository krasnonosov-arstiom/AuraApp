package com.example.data.impl.repositories

import com.example.data.database.AuraDBDao
import com.example.data.database.entities.BootInfoEntity
import com.example.domain.models.BootInfoModel
import com.example.domain.repositories.NumberRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class NumberRepositoryImpl @Inject constructor(
    private val auraDBDao: AuraDBDao,
) : NumberRepository {

    override suspend fun writeValue(newBootTime: Long) {
        withContext(Dispatchers.IO) {
            auraDBDao.insertBootInfoValue(BootInfoEntity(newBootTime))
        }
    }

    override fun getSavedNumbersStream(): Flow<BootInfoModel> =
        auraDBDao.getBootInfoValues()
            .map { bootInfoEntities ->
                when (bootInfoEntities.size) {
                    0 -> BootInfoModel.NoValues
                    1 -> BootInfoModel.LastValue(bootInfoEntities.last().bootTime)
                    else -> {
                        val lastTime = bootInfoEntities.last().bootTime
                        val preLastTime = bootInfoEntities.getOrNull(bootInfoEntities.size - 2)?.bootTime ?: 0
                        BootInfoModel.TwoLastValues(lastTime = lastTime, preLastTime = preLastTime)
                    }
                }
            }
}
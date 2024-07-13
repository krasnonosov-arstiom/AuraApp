package com.example.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.data.database.entities.BootInfoEntity
import com.example.data.database.entities.BootInfoEntity.Companion.BOOT_INFO_ENTITY_NAME
import kotlinx.coroutines.flow.Flow

@Dao
interface AuraDBDao {

    @Insert
    suspend fun insertBootInfoValue(bootInfoEntity: BootInfoEntity)

    @Delete
    suspend fun removeBootInfoValue(bootInfoEntity: BootInfoEntity)

    @Query("SELECT * FROM $BOOT_INFO_ENTITY_NAME")
    fun getBootInfoValues(): Flow<List<BootInfoEntity>>
}
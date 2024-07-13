package com.example.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.database.entities.BootInfoEntity.Companion.BOOT_INFO_ENTITY_NAME

@Entity(tableName = BOOT_INFO_ENTITY_NAME)
class BootInfoEntity(
    @PrimaryKey @ColumnInfo(name = "boot_time") val bootTime: Long,
) {

    companion object {

        const val BOOT_INFO_ENTITY_NAME = "boot_info_entity"
    }
}
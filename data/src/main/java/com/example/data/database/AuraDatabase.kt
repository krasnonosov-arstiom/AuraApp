package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.database.entities.BootInfoEntity

@Database(entities = [BootInfoEntity::class], version = 1)
abstract class AuraDatabase: RoomDatabase() {

    abstract fun createDao(): AuraDBDao

    companion object {

        const val DATABASE_NAME = "aura_database_name"
    }
}
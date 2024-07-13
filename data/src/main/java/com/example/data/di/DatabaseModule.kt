package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.database.AuraDBDao
import com.example.data.database.AuraDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabaseInstance(context: Context): AuraDatabase =
        Room.databaseBuilder(context, AuraDatabase::class.java, AuraDatabase.DATABASE_NAME).build()

    @Singleton
    @Provides
    fun databaseDao(database: AuraDatabase): AuraDBDao = database.createDao()
}
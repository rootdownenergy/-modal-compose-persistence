package com.example.lulu.di

import android.content.Context
import androidx.room.Room
import com.example.lulu.data.data_sources.local.AppDatabase
import com.example.lulu.data.data_sources.local.GarmentDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideGarmentDao(appDatabase: AppDatabase): GarmentDao {
        return appDatabase.getGarmentDao()
    }
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "main_db"
        ).build()
    }
}
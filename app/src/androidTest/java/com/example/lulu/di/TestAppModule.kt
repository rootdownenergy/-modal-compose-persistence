package com.example.lulu.di

import android.app.Application
import androidx.room.Room
import com.example.lulu.LuluLemonApp
import com.example.lulu.data.data_sources.local.AppDatabase
import com.example.lulu.domain.repo.GarmentRepoImpl
import com.example.lulu.domain.repo.GarmentsRepo
import com.example.lulu.domain.use_cases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

    @Provides
    @Singleton
    fun provideGarmentRepo(db: AppDatabase): GarmentsRepo {
        return GarmentRepoImpl(db.getGarmentDao())
    }


    @Provides
    @Singleton
    fun provideGarmentRepo(app: Application): AppDatabase {
        return Room.inMemoryDatabaseBuilder(
            app,
            AppDatabase::class.java,
        ).build()
    }


    @Provides
    @Singleton
    fun provideGarmentUseCases(repo: GarmentsRepo): GarmentsUseCases {
        return GarmentsUseCases(
            getGarments = GetGarments(repo),
            deleteGarment = DeleteGarment(repo),
            addGarment = AddGarment(repo),
            getGarmentById = GetGarmentById(repo),
            updateGarment = UpdateGarment(repo)
        )
    }
}
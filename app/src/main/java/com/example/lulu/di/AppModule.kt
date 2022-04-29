package com.example.lulu.di

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
object AppModule {

    @Provides
    @Singleton
    fun provideGarmentRepo(db: AppDatabase): GarmentsRepo {
        return GarmentRepoImpl(db.getGarmentDao())
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
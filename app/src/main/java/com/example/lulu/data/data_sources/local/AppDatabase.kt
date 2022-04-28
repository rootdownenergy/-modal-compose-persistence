package com.example.lulu.data.data_sources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lulu.domain.model.Garment

@Database(
    entities = [Garment::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getGarmentDao(): GarmentDao
}
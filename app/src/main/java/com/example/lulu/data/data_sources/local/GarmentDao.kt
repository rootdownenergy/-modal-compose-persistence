package com.example.lulu.data.data_sources.local

import androidx.room.*
import com.example.lulu.domain.model.Garment
import kotlinx.coroutines.flow.Flow

@Dao
interface GarmentDao {
    @Query("SELECT * FROM garment_main")
    fun getGarment(): Flow<List<Garment>>

    @Query("SELECT * FROM garment_main WHERE garnmentId = :id")
    suspend fun getGarmentById(id: Int): Garment?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGarment(data: Garment)

    @Delete
    suspend fun deleteGarment(garment: Garment)

    @Update
    suspend fun updateGarment(garment: Garment)

}
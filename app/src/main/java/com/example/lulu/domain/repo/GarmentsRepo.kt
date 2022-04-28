package com.example.lulu.domain.repo

import com.example.lulu.domain.model.Garment
import kotlinx.coroutines.flow.Flow


interface GarmentsRepo {
    fun getGarments(): Flow<List<Garment>>
    // standard crud get
    suspend fun getGarmentById(id: Int): Garment?
    // standard crud insert
    suspend fun insertGarment(data: Garment)
    // standard crud delete
    suspend fun deleteGarment(data: Garment)
}
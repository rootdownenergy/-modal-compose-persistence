package com.example.lulu.domain.repo

import com.example.lulu.domain.model.Garment
import kotlinx.coroutines.flow.Flow

class GarmentRepoImpl : GarmentsRepo {
    override fun getGarments(): Flow<List<Garment>> {
        TODO("Not yet implemented")
    }

    override suspend fun getGarmentById(id: Int): Garment? {
        TODO("Not yet implemented")
    }

    override suspend fun insertGarment(data: Garment) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteGarment(data: Garment) {
        TODO("Not yet implemented")
    }
}
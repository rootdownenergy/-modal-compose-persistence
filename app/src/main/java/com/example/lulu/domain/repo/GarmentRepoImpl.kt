package com.example.lulu.domain.repo

import android.util.Log
import com.example.lulu.data.data_sources.local.GarmentDao
import com.example.lulu.domain.model.Garment
import kotlinx.coroutines.flow.Flow

class GarmentRepoImpl(
    private val dao: GarmentDao
) : GarmentsRepo {
    override fun getGarments(): Flow<List<Garment>> {
        return dao.getGarment()
    }

    override suspend fun getGarmentById(id: Int): Garment? {
          return dao.getGarmentById(id)
    }

    override suspend fun insertGarment(data: Garment) {
        dao.insertGarment(data)
    }

    override suspend fun deleteGarment(data: Garment) {
        dao.deleteGarment(data.garnmentId)
    }
}
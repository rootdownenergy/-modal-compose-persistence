package com.example.lulu.domain.repo

import android.util.Log
import com.example.lulu.domain.model.Garment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class FakeGarmentsRepo : GarmentsRepo {
    val lsGarments = listOf(
        Garment(garnmentId = 1, name = "HTW", description = "HTWHTWHTWHTW", timestamp = System.currentTimeMillis()+1, color = 2),
        Garment(garnmentId = 2, name = "HTW2", description = "HTWHTWHTWHTW2", timestamp = System.currentTimeMillis()+2, color = 33),
        Garment(garnmentId = 3, name = "HTW3", description = "HTWHTWHTWHTW3", timestamp = System.currentTimeMillis()+3, color = 1),
        Garment(garnmentId = 4, name = "HTW4", description = "HTWHTWHTWHTW4", timestamp = System.currentTimeMillis()+4, color = 244),
    )
    val modLs = lsGarments.toMutableList()
    override fun getGarments(): Flow<List<Garment>> {
        return flow<List<Garment>> {
            emit(lsGarments)
        }
    }

    override suspend fun getGarmentById(id: Int): Garment? {
        return try {
            lsGarments[id]
        } catch (e: Exception){
            Garment(name = "ERROR", description = "unknown error",timestamp = System.currentTimeMillis(), color = 2)
        }
    }

    override suspend fun insertGarment(data: Garment) {
        try {
            modLs.add(data)
        }catch (e: Exception){
            Log.w("$$$", "An unknown error occurred")
        }

    }

    override suspend fun deleteGarment(data: Garment) {
        try {
            modLs.remove(data)
        }catch (e: Exception){
            Log.w("$$$", "An unknown error occurred")
        }
    }

    override suspend fun updateGarment(data: Garment) {
        TODO("Not yet implemented")
    }
}
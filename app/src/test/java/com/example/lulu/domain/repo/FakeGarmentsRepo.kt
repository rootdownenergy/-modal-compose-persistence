package com.example.lulu.domain.repo

import android.util.Log
import com.example.lulu.domain.model.Garment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class FakeGarmentsRepo : GarmentsRepo {
    val lsGarments = listOf(
        Garment(name = "HTW", description = "HTWHTWHTWHTW", timestamp = System.currentTimeMillis(), color = 2, ii = "cloud group"),
        Garment(name = "HTW2", description = "HTWHTWHTWHTW2", timestamp = System.currentTimeMillis(), color = 2, ii = "cloud group"),
        Garment(name = "HTW3", description = "HTWHTWHTWHTW3", timestamp = System.currentTimeMillis(), color = 2, ii = "cloud group"),
        Garment(name = "HTW4", description = "HTWHTWHTWHTW4", timestamp = System.currentTimeMillis(), color = 2, ii = "cloud group"),
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
            Garment(name = "ERROR", description = "unknown error",timestamp = 101L, color = 2, ii = "error group")
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
}
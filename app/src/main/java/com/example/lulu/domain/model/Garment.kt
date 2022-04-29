package com.example.lulu.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.lulu.presentation.util.theme.*

@Entity(tableName = "garment_main")
data class Garment(
    @PrimaryKey(autoGenerate = true)
    var garnmentId: Int = 0,
    val name: String,
    val description: String,
    val timestamp: Long,
    val color: Int,
){
    companion object {
        val garmentColor = listOf(Blue200, Blue500, Blue700, Yellow200, Yellow500, Yellow700)
    }
}

class InvalidGarmentException(message: String): Exception(message)
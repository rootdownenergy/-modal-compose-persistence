package com.example.lulu.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.lulu.presentation.util.theme.Blue200
import com.example.lulu.presentation.util.theme.Blue500
import com.example.lulu.presentation.util.theme.Blue700

@Entity(tableName = "garment_main")
data class Garment(
    val name: String,
    val description: String,
    val timestamp: Long,
    val color: Int,
    val ii: String,
){
    @PrimaryKey(autoGenerate = true)
    var garnmentId: Int = 0
    companion object {
        val garmentColor = listOf(Blue200, Blue500, Blue700)
    }
}

class InvalidGarmentException(message: String): Exception(message)
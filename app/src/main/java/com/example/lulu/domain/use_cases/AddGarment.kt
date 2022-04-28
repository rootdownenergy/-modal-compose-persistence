package com.example.lulu.domain.use_cases

import com.example.lulu.domain.model.Garment
import com.example.lulu.domain.model.InvalidGarmentException
import com.example.lulu.domain.repo.GarmentsRepo

class AddGarment(
    private val repo: GarmentsRepo
) {
    @Throws(InvalidGarmentException::class)
    suspend operator fun invoke(garment: Garment) {
        if(garment.name.isBlank()) {
            throw InvalidGarmentException("The name of the garment cannot be blank")
        }
        if(garment.description.isBlank()) {
            throw InvalidGarmentException("The description of the garment cannot be blank")
        }
        repo.insertGarment(garment)
    }
}
package com.example.lulu.domain.use_cases

import com.example.lulu.domain.model.Garment
import com.example.lulu.domain.repo.GarmentsRepo

class UpdateGarment(
    private val repo: GarmentsRepo
) {
    suspend operator fun invoke(garment: Garment) {
        repo.updateGarment(garment)
    }
}
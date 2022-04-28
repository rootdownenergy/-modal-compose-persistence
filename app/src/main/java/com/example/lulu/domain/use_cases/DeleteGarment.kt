package com.example.lulu.domain.use_cases

import com.example.lulu.domain.model.Garment
import com.example.lulu.domain.repo.GarmentsRepo

class DeleteGarment(
    private val repo: GarmentsRepo
) {
    suspend operator fun invoke(data: Garment) {
        repo.deleteGarment(data)
    }
}
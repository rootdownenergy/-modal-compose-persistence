package com.example.lulu.domain.use_cases

import com.example.lulu.domain.model.Garment
import com.example.lulu.domain.repo.GarmentsRepo


class GetGarmentById(
    private val repo: GarmentsRepo
) {
    suspend operator fun invoke(id: Int): Garment? {
        return repo.getGarmentById(id)
    }
}
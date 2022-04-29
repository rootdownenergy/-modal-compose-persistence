package com.example.lulu.domain.use_cases

data class GarmentsUseCases(
    val getGarments: GetGarments,
    val deleteGarment: DeleteGarment,
    val addGarment: AddGarment,
    val getGarmentById: GetGarmentById,
    val updateGarment: UpdateGarment,
)

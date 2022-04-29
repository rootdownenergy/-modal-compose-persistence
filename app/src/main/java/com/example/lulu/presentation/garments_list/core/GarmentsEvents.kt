package com.example.lulu.presentation.garments_list.core

import com.example.lulu.domain.model.Garment
import com.example.lulu.domain.util.GarmentOrder

sealed class GarmentsEvents {
    data class Order(val garmentOrder: GarmentOrder): GarmentsEvents()
    data class DeleteGarment(val garment: Garment): GarmentsEvents()
    object RestoreGarment: GarmentsEvents()
    object ToggleOrderSection: GarmentsEvents()
}
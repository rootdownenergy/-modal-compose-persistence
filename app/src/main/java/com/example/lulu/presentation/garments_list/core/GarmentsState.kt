package com.example.lulu.presentation.garments_list.core

import com.example.lulu.domain.model.Garment
import com.example.lulu.domain.util.GarmentOrder
import com.example.lulu.domain.util.OrderType

data class GarmentsState(
    val garments: List<Garment> = emptyList(),
    val garmentOrder: GarmentOrder = GarmentOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
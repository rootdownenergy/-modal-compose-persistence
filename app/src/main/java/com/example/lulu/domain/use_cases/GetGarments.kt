package com.example.lulu.domain.use_cases

import com.example.lulu.domain.model.Garment
import com.example.lulu.domain.repo.GarmentsRepo
import com.example.lulu.domain.util.GarmentOrder
import com.example.lulu.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class GetGarments(
    private val repo: GarmentsRepo
) {
    operator fun invoke(
        garmentOrder: GarmentOrder = GarmentOrder.Date(OrderType.Descending)
    ): Flow<List<Garment>> {
        //get garments/ sort
        return repo.getGarments().map { garments ->
            when(garmentOrder.orderType){
                is OrderType.Ascending -> {
                    when(garmentOrder){
                        is GarmentOrder.Name -> garments.sortedBy { it.name.lowercase() }
                        is GarmentOrder.Color -> garments.sortedBy { it.color}
                        is GarmentOrder.Date -> garments.sortedBy { it.timestamp }
                    }
                }
                is OrderType.Descending -> {
                    when(garmentOrder){
                        is GarmentOrder.Name -> garments.sortedByDescending { it.name.lowercase() }
                        is GarmentOrder.Color -> garments.sortedByDescending { it.color }
                        is GarmentOrder.Date -> garments.sortedByDescending { it.timestamp }
                    }
                }
            }
        }
    }
}
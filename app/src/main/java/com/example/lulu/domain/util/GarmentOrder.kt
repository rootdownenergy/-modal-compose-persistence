package com.example.lulu.domain.util

sealed class GarmentOrder(val orderType: OrderType) {
    class Name(orderType: OrderType): GarmentOrder(orderType)
    class Date(orderType: OrderType): GarmentOrder(orderType)
    class Color(orderType: OrderType): GarmentOrder(orderType)

    fun copy(orderType: OrderType): GarmentOrder {
        return when(this) {
            is Name -> Name(orderType)
            is Date -> Date(orderType)
            is Color -> Color(orderType)
        }
    }
}
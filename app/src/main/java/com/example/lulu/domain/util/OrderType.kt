package com.example.lulu.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
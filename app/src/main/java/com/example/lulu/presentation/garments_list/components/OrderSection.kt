package com.example.lulu.presentation.garments_list.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.lulu.domain.util.GarmentOrder
import com.example.lulu.domain.util.OrderType

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    garmentOrder: GarmentOrder = GarmentOrder.Date(OrderType.Descending),
    onOrderChange: (GarmentOrder) -> Unit
){
    Column(
        modifier = Modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

        }
    }
}
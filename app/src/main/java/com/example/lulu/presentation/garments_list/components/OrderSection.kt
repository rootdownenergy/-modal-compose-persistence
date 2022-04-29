package com.example.lulu.presentation.garments_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.lulu.domain.util.GarmentOrder
import com.example.lulu.domain.util.OrderType
import com.example.lulu.presentation.util.theme.secondaryDark

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    garmentOrder: GarmentOrder = GarmentOrder.Date(OrderType.Descending),
    onOrderChange: (GarmentOrder) -> Unit
){
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = modifier.fillMaxWidth()
        ) {
            DefaultFilterButton(
                text = "Name",
                selected = garmentOrder is GarmentOrder.Name,
                onSelected = { onOrderChange(GarmentOrder.Name(garmentOrder.orderType))}
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultFilterButton(
                text = "Date",
                selected = garmentOrder is GarmentOrder.Date,
                onSelected = { onOrderChange(GarmentOrder.Date(garmentOrder.orderType))}
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultFilterButton(
                text = "Color",
                selected = garmentOrder is GarmentOrder.Color,
                onSelected = { onOrderChange(GarmentOrder.Color(garmentOrder.orderType))}
            )
        }
    }
}
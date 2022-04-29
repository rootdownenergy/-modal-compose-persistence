package com.example.lulu.presentation.garments_list.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            DefaultFilterButton(
                text = "Name",
                selected = garmentOrder is GarmentOrder.Name,
                onSelected = {
                    if(garmentOrder.orderType == OrderType.Ascending){
                        onOrderChange(GarmentOrder.Name(garmentOrder.orderType))
                        onOrderChange(garmentOrder.copy(OrderType.Descending))
                    } else {
                        onOrderChange(GarmentOrder.Name(garmentOrder.orderType))
                        onOrderChange(garmentOrder.copy(OrderType.Ascending))
                    }
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultFilterButton(
                text = "Creation Time",
                selected = garmentOrder is GarmentOrder.Date,
                onSelected = {
                    if(garmentOrder.orderType == OrderType.Ascending){
                        onOrderChange(GarmentOrder.Date(garmentOrder.orderType))
                        onOrderChange(garmentOrder.copy(OrderType.Descending))
                    } else {
                        onOrderChange(GarmentOrder.Date(garmentOrder.orderType))
                        onOrderChange(garmentOrder.copy(OrderType.Ascending))
                    }
                }
            )
        }
    }
}
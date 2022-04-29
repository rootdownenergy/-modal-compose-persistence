package com.example.lulu.presentation.garments_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lulu.presentation.util.theme.secondaryDark
import com.example.lulu.presentation.util.theme.secondaryLight
import com.example.lulu.presentation.util.theme.secondaryText

@Composable
fun DefaultFilterButton(
    text: String,
    selected: Boolean,
    onSelected: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = onSelected,
            content = {
                modifier
                    .width(75.dp)
                Text(
                    text = text,
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
        )
    }
}
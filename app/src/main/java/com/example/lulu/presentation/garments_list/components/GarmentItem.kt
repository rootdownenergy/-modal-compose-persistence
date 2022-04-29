package com.example.lulu.presentation.garments_list.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils
import com.example.lulu.domain.model.Garment
import com.example.lulu.presentation.util.theme.Yellow200
import com.example.lulu.presentation.util.theme.primaryDark
import com.example.lulu.presentation.util.theme.primaryText

@Composable
fun GarmentItem(
    garment: Garment,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 10.dp,
    cutCornerSize: Dp = 30.dp,
    onDeleteClick: () -> Unit
){
    Box(
        modifier = modifier

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            content = {
                Card(
                    elevation = 4.dp,
                    modifier = Modifier.padding(all = 4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(all = 4.dp)
                    )
                    {

                        Canvas(modifier = Modifier.fillMaxWidth()) {
                            val clipPath = Path().apply {
                                lineTo(size.width - cutCornerSize.toPx(), 0f)
                                lineTo(size.width, cutCornerSize.toPx())
                                lineTo(size.width, size.height)
                                lineTo(0f, size.height)
                                close()
                            }
                            clipPath(clipPath) {
                                drawRoundRect(
                                    color = Yellow200,
                                    size = size,
                                    cornerRadius = CornerRadius(cornerRadius.toPx())
                                )
                                drawRoundRect(
                                    color = Color(
                                        ColorUtils.blendARGB(garment.color, 0x000000, 0.2f)
                                    ),
                                    topLeft = Offset(size.width - cutCornerSize.toPx(), -100f),
                                    size = Size(cutCornerSize.toPx() + 100f, cutCornerSize.toPx() + 100f),
                                    cornerRadius = CornerRadius(cornerRadius.toPx())
                                )
                            }
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color(garment.color))
                                .padding(4.dp)
                                .padding(end = 10.dp)
                        ) {
                            Text(
                                text = garment.name,
                                style = MaterialTheme.typography.h1,
                                color = Color.Cyan,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = garment.description,
                                style = MaterialTheme.typography.body1,
                                color = Color.Cyan,
                                maxLines = 10,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                        IconButton(
                            onClick = onDeleteClick,
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Delete Garment",
                                tint = Color.Cyan
                            )
                        }
                    }
                }
            }
        )

    }
}
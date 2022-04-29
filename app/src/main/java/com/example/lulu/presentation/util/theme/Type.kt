package com.example.lulu.presentation.util.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.lulu.R


val fontModal = FontFamily(
    Font(R.font.arr)
)
val fontGarmentItem = FontFamily(
    Font(R.font.michromareg)
)
// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = fontModal,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = secondaryText,
    ),
    h1 = TextStyle(
        fontFamily = fontModal,
        fontWeight = FontWeight.Bold,
        color = secondaryText,
        fontSize = 20.sp
    ),
    body2 = TextStyle(
        color = secondaryText,
        fontFamily = fontGarmentItem,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    h2 = TextStyle(
        fontFamily = fontGarmentItem,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

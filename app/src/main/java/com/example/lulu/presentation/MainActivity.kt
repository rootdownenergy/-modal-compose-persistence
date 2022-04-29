package com.example.lulu.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.lulu.presentation.garments_list.components.ModalBottomSheetLayoutScreen
import com.example.lulu.presentation.util.theme.LuluTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LuluTheme(darkTheme = false) {
                ModalBottomSheetLayoutScreen()
            }
        }
    }
}

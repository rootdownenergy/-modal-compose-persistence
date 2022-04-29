package com.example.lulu.presentation.garments_list.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import com.example.lulu.R
import com.example.lulu.presentation.add_garments.components.AddEditGarmentScreen
import com.example.lulu.presentation.util.theme.primaryDark
import com.example.lulu.presentation.util.theme.secondary
import com.example.lulu.presentation.util.theme.secondaryDark

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ModalBottomSheetLayoutScreen() {

    val modalBottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()

    ModalBottomSheetLayout(
        sheetContent = {
            AddEditGarmentScreen(garmentColor = primaryDark.toArgb(), state = modalBottomSheetState)
        },
        sheetState = modalBottomSheetState,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetBackgroundColor = secondaryDark,
    ) {
        Scaffold(
            topBar = { TopAppBarMain(scope = scope, state = modalBottomSheetState) },
            backgroundColor = secondary
        ) {
            GarmentsListScreen(state = modalBottomSheetState)
        }
    }
}
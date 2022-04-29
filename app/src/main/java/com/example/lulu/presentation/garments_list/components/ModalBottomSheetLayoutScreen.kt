package com.example.lulu.presentation.garments_list.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import com.example.lulu.R
import com.example.lulu.presentation.add_garments.components.AddEditGarmentScreen
import com.example.lulu.presentation.util.theme.primaryDark
import com.example.lulu.presentation.util.theme.secondary
import com.example.lulu.presentation.util.theme.secondaryDark

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun ModalBottomSheetLayoutScreen(
    scrollableState: ScrollState = rememberScrollState()
) {

    val modalBottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()

    ModalBottomSheetLayout(
        sheetContent = {
                Column(
                    modifier = Modifier
                        .verticalScroll(scrollableState)
                ) {
                    AddEditGarmentScreen(garmentColor = secondaryDark.toArgb(), state = modalBottomSheetState)
                }
            },
        sheetState = modalBottomSheetState,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetBackgroundColor = secondaryDark,
    ) {
        Scaffold(
            topBar = { TopAppBarMain(scope = scope, state = modalBottomSheetState) },
        ) {
            GarmentsListScreen(state = modalBottomSheetState)
        }
    }
}
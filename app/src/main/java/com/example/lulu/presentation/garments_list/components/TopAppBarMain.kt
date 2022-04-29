package com.example.lulu.presentation.garments_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.lulu.R
import com.example.lulu.presentation.garments_list.core.GarmentsListViewModel
import com.example.lulu.presentation.util.theme.secondaryDark
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TopAppBarMain(
    scope: CoroutineScope,
    state: ModalBottomSheetState,
    viewModel: GarmentsListViewModel = hiltViewModel()
){
    Box(
        Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.TopEnd)
            .background(secondaryDark)
    ) {
        IconButton(onClick = {
            scope.launch {
                state.show()
            }
        }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_add_circle_outline_24),
                contentDescription = null // decorative element
            )
        }
    }
}
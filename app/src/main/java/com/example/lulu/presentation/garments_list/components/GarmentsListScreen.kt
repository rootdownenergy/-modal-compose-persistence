package com.example.lulu.presentation.garments_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.lulu.R
import com.example.lulu.presentation.add_garments.core.AddEditGarmentViewModel
import com.example.lulu.presentation.garments_list.core.GarmentsEvents
import com.example.lulu.presentation.garments_list.core.GarmentsListViewModel
import com.example.lulu.presentation.util.theme.Yellow700
import com.example.lulu.presentation.util.theme.primaryText
import com.example.lulu.presentation.util.theme.secondary
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GarmentsListScreen(
    state: ModalBottomSheetState,
    viewModel: GarmentsListViewModel = hiltViewModel(),
    addEditViewModel: AddEditGarmentViewModel = hiltViewModel()
){
    val stateViewModel = viewModel.state.value
    val scaffoldState = rememberScaffoldState()
    val scope =  rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Lulu Garments + ",
                    style = MaterialTheme.typography.h1
                )
                LazyColumn(modifier = Modifier.fillMaxSize()){
                    items(stateViewModel.garments) { garment ->
                        GarmentItem(
                            garment = garment,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    addEditViewModel.currentGarment = garment
                                    scope.launch {
                                        state.show()
                                    }
                                },
                            onDeleteClick = {
                                viewModel.onEvent(GarmentsEvents.DeleteGarment(garment))
                                scope.launch {
                                    val result = scaffoldState.snackbarHostState.showSnackbar(
                                        message = "Garment Deleted",
                                        actionLabel = "Undo"
                                    )
                                    if(result == SnackbarResult.ActionPerformed) {
                                        viewModel.onEvent(GarmentsEvents.RestoreGarment)
                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}


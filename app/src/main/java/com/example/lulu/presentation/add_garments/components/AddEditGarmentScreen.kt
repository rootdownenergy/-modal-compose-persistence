package com.example.lulu.presentation.add_garments.components

import android.graphics.drawable.shapes.RoundRectShape
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.lulu.presentation.add_garments.core.AddEditGarmentViewModel
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.lulu.R
import com.example.lulu.domain.model.Garment
import com.example.lulu.presentation.add_garments.core.AddEditGarmentEvents
import com.example.lulu.presentation.util.theme.Blue500
import com.example.lulu.presentation.util.theme.Blue700
import com.example.lulu.presentation.util.theme.primaryLight
import com.example.lulu.presentation.util.theme.secondary
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AddEditGarmentScreen(
    state: ModalBottomSheetState,
    garmentColor: Int,
    viewModel: AddEditGarmentViewModel = hiltViewModel()
){
    val nameState = viewModel.garmentName.value
    val descriptionState = viewModel.garmentDescription.value
    val scaffoldState = rememberScaffoldState()
    val garmentBackgroundAnimatable = remember {
        Animatable(
            Color(if(garmentColor != -1) garmentColor else viewModel.garmentColor.value)
        )
    }
    val scope = rememberCoroutineScope()
    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when(event){
                is AddEditGarmentViewModel.UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
                is AddEditGarmentViewModel.UiEvent.SaveGarment -> {
                    // close the modal
                    scope.launch {
                        state.hide()
                    }
                }
            }
        }
    }
    Scaffold(
        scaffoldState = scaffoldState,
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .background(garmentBackgroundAnimatable.value)
                .padding(5.dp)
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Garment.garmentColor.forEach { color ->
                    val colorInt = color.toArgb()
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .shadow(15.dp, RoundedCornerShape(15))
                            .clip(RoundedCornerShape(15))
                            .background(color)
                            .border(
                                width = 3.dp,
                                color = if (viewModel.garmentColor.value == colorInt) {
                                    Blue700
                                } else Color.Transparent,
                                shape = RoundedCornerShape(15)
                            )
                            .clickable {
                                scope.launch {
                                    garmentBackgroundAnimatable.animateTo(
                                        targetValue = Color(colorInt),
                                        animationSpec = tween(
                                            durationMillis = 500
                                        )
                                    )
                                }
                                viewModel.onEvent(AddEditGarmentEvents.ChangeColor(colorInt))
                            }
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                            viewModel.onEvent(AddEditGarmentEvents.SaveGarment)
                    }
                ) {
                    Icon(
                        Icons.Default.Save,
                        contentDescription = null,
                        modifier = Modifier
                            .background(Color.Cyan)
                            .size(50.dp),
                        tint = Color.Yellow
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Divider(
                modifier = Modifier.fillMaxWidth(),
                color = Color.LightGray,
                thickness = 1.dp,
                startIndent = 0.dp
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TransparentHintTextField(
                    text = nameState.text,
                    hint = nameState.hint,
                    onValueChange = {
                        viewModel.onEvent(AddEditGarmentEvents.EnteredName(it))
                    },
                    onFocusChange = {
                        viewModel.onEvent(AddEditGarmentEvents.ChangeNameFocus(it))
                    },
                    isHintVisible = nameState.isHintVisible,
                    singleLine = true,
                    textStyle = MaterialTheme.typography.h2
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Divider(
                modifier = Modifier.fillMaxWidth(),
                color = Color.LightGray,
                thickness = 1.dp,
                startIndent = 0.dp
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TransparentHintTextField(
                    text = descriptionState.text,
                    hint = descriptionState.hint,
                    onValueChange = {
                        viewModel.onEvent(AddEditGarmentEvents.EnteredDescription(it))
                    },
                    onFocusChange = {
                        viewModel.onEvent(AddEditGarmentEvents.ChangeDescriptionFocus(it))
                    },
                    isHintVisible = descriptionState.isHintVisible,
                    textStyle = MaterialTheme.typography.body2,
                    modifier = Modifier
                        .fillMaxHeight()
                )
            }

        }
    }

}



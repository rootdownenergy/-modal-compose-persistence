package com.example.lulu.presentation.garments_list.components

import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.lulu.presentation.garments_list.core.GarmentsListViewModel

@Composable
fun GarmentsScreen(
    viewModel: GarmentsListViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()
    val scope =  rememberCoroutineScope()



}


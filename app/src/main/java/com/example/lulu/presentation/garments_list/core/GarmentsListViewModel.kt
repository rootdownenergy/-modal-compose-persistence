package com.example.lulu.presentation.garments_list.core

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.lulu.domain.model.Garment
import com.example.lulu.domain.use_cases.GarmentsUseCases
import com.example.lulu.domain.util.GarmentOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import javax.inject.Inject

@HiltViewModel
class GarmentsListViewModel @Inject constructor(
    private val garmentsUseCases: GarmentsUseCases
) : ViewModel() {

    private val _state = mutableStateOf<GarmentsState>(GarmentsState())
    val state: State<GarmentsState> = _state

    //store most recent garment
    private var recentlyDeletedGarment: Garment? = null

    //keep track of current flow
    private var getGarmentsJob: Job? = null

    init {

    }


    private fun getGarments(garmentOrder: GarmentOrder){
        getGarmentsJob?.cancel()

    }
}
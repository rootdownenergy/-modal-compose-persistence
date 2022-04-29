package com.example.lulu.presentation.garments_list.core

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lulu.domain.model.Garment
import com.example.lulu.domain.use_cases.GarmentsUseCases
import com.example.lulu.domain.util.GarmentOrder
import com.example.lulu.domain.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
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
        getGarments(GarmentOrder.Date(OrderType.Descending))
    }

    fun onEvent(event: GarmentsEvents){
        when(event){
            is GarmentsEvents.Order -> {
                // user clicks on the same ordering and same order type
                if(state.value.garmentOrder::class == event.garmentOrder::class &&
                    state.value.garmentOrder.orderType == event.garmentOrder.orderType) {
                    return
                }
                getGarments(event.garmentOrder)
            }
            is GarmentsEvents.DeleteGarment -> {
                viewModelScope.launch {
                    garmentsUseCases.deleteGarment(event.garment)
                    recentlyDeletedGarment = event.garment
                }
            }
            is GarmentsEvents.RestoreGarment -> {
                viewModelScope.launch {
                    garmentsUseCases.addGarment(recentlyDeletedGarment ?: return@launch)
                    recentlyDeletedGarment = null
                }
            }
            is GarmentsEvents.ToggleModalSection -> {
                _state.value = state.value.copy(
                    isModalSectionVisible = !state.value.isModalSectionVisible
                )
            }
        }
    }

    private fun getGarments(garmentOrder: GarmentOrder){
        getGarmentsJob?.cancel()
        getGarmentsJob = garmentsUseCases.getGarments(garmentOrder)
            .onEach { garments ->
                _state.value = state.value.copy(
                    garments = garments,
                    garmentOrder = garmentOrder
                )
            }
            .launchIn(viewModelScope)
    }
}
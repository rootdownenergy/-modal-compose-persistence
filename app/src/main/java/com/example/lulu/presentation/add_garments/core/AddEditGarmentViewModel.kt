package com.example.lulu.presentation.add_garments.core

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lulu.domain.model.Garment
import com.example.lulu.domain.model.InvalidGarmentException
import com.example.lulu.domain.use_cases.GarmentsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditGarmentViewModel @Inject constructor(
    private val garmentsUseCases: GarmentsUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    lateinit var currentGarment: Garment

    private val _garmentName = mutableStateOf(AddEditGarmentState(
        hint = "Enter garment name..."
    ))
    val garmentName: State<AddEditGarmentState> = _garmentName

    private val _garmentDescription = mutableStateOf(AddEditGarmentState(
        hint = "Enter garment description..."
    ))
    val garmentDescription: State<AddEditGarmentState> = _garmentDescription

    private val _garmentColor = mutableStateOf(Garment.garmentColor.random().toArgb())
    val garmentColor: State<Int> = _garmentColor

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var currentGarmentId: Int = 0

    init {

    }

    fun onEvent(event: AddEditGarmentEvents){
        when(event){
            is AddEditGarmentEvents.EnteredName -> {
                _garmentName.value = garmentName.value.copy(
                    text = event.value
                )
            }
            is AddEditGarmentEvents.ChangeNameFocus -> {
                _garmentName.value = _garmentName.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            garmentName.value.text.isBlank()
                )
            }
            is AddEditGarmentEvents.EnteredDescription -> {
                _garmentDescription.value = garmentDescription.value.copy(
                    text = event.value
                )
            }
            is AddEditGarmentEvents.ChangeDescriptionFocus -> {
                _garmentDescription.value = _garmentDescription.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            garmentDescription.value.text.isBlank()
                )
            }
            is AddEditGarmentEvents.ChangeColor -> {
                _garmentColor.value = event.color
            }
            is AddEditGarmentEvents.SaveGarment -> {
                viewModelScope.launch {
                    try {
                        garmentsUseCases.addGarment(
                            Garment(
                                name = garmentName.value.text,
                                description = garmentDescription.value.text,
                                timestamp = System.currentTimeMillis(),
                                color = garmentColor.value
                            )
                        )
                        _eventFlow.emit(UiEvent.SaveGarment)
                    }catch (e: InvalidGarmentException){
                        _eventFlow.emit(
                            UiEvent.ShowSnackbar(
                                message = e.message ?: "Unknown Error"
                            )
                        )
                    }

                }
            }
        }
    }

    sealed class UiEvent {
        data class ShowSnackbar(val message: String): UiEvent()
        object SaveGarment: UiEvent()
    }
}
package com.example.lulu.presentation.add_garments.core

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.lulu.domain.use_cases.GarmentsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddEditGarmentViewModel @Inject constructor(
    private val garmentsUseCases: GarmentsUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

}
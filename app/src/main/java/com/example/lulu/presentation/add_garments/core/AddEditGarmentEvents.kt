package com.example.lulu.presentation.add_garments.core

import androidx.compose.ui.focus.FocusState

sealed class AddEditGarmentEvents {
    data class EnteredName(val value: String): AddEditGarmentEvents()
    data class EnteredDescription(val value: String): AddEditGarmentEvents()
    data class ChangeNameFocus(val focusState: FocusState): AddEditGarmentEvents()
    data class ChangeDescriptionFocus(val focusState: FocusState): AddEditGarmentEvents()
    data class ChangeColor(val color: Int): AddEditGarmentEvents()
    object SaveGarment: AddEditGarmentEvents()
}
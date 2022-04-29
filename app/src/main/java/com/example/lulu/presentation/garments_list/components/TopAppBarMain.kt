package com.example.lulu.presentation.garments_list.components



import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Sort
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.lulu.R
import com.example.lulu.presentation.garments_list.core.GarmentsEvents
import com.example.lulu.presentation.garments_list.core.GarmentsListViewModel
import com.example.lulu.presentation.util.theme.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TopAppBarMain(
    scope: CoroutineScope,
    state: ModalBottomSheetState,
    viewModel: GarmentsListViewModel = hiltViewModel()
){
    Column(
        modifier = Modifier.fillMaxWidth().background(secondaryDark).border(4.dp, secondary)
    ) {
        Row(
            modifier = Modifier.padding(10.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                modifier = Modifier.border(3.dp, secondaryLight).background(primaryDark).padding(10.dp),
                onClick = {
                    viewModel.onEvent(GarmentsEvents.ToggleOrderSection)
                },
            ){
                Icon(
                    modifier = Modifier.size(50.dp),
                    imageVector = Icons.Default.Sort,
                    contentDescription = "Sort",
                    tint = primaryText,
                )
            }
            IconButton(
                modifier = Modifier.border(3.dp, secondaryLight).background(primaryDark).padding(10.dp),
                onClick = {
                    scope.launch {
                        state.show()
                    }
                }
            ) {
                Icon(
                    modifier = Modifier.size(50.dp),
                    painter = painterResource(id = R.drawable.ic_baseline_add_circle_outline_24),
                    contentDescription = null, // decorative element
                    tint = primaryText,
                )
            }
        }
    }
}
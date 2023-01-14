package com.example.adapter.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.adapter.Affirmation
import com.example.adapter.Data.StoreUserEmail
import com.example.adapter.GameViewModel
import com.example.adapter.WellnessTask
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@Composable
fun GameScreen(
    modifier: Modifier = Modifier,
    viewModel: GameViewModel = viewModel(),

    ) {

    val gameUiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current
    // scope
    val scope = rememberCoroutineScope()
    // datastore Email
    val dataStore = StoreUserEmail(context)
    // get saved email
    val savedEmail = dataStore.getEmail.collectAsState(initial = "")

    var email = gameUiState.usedCards

    var UserGuess = gameUiState.currentCards

    Column( modifier = modifier
       .padding(16.dp),
       verticalArrangement = Arrangement.spacedBy(8.dp)) {
       Button(
           modifier = modifier
               .width(151.dp)
               .height(70.dp)
               .padding(start = 8.dp),
           onClick = { scope.launch {

            viewModel.Skott()

           } }
       ) {
           Text(text = "Hulk", fontSize = 18.sp)
       }
        Row(modifier = modifier
            .padding(16.dp),
        ){

          // MasTaskList(list = email)
            //MasTaskList(list = UserGuess)
            WellnesTaskList(list = viewModel.tasks,
                onCloseTask = {task -> viewModel.remove(task)},
                onAddTask = {task -> viewModel.gult(task)})
            WellnesTaskList(list = viewModel.again,
                onCloseTask = {punto -> viewModel.remove(punto)},
                onAddTask = {punto -> viewModel.gilf(punto)})

        }

   }
}







package com.example.adapter.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.adapter.Data.StoreUserEmail
import com.example.adapter.GameViewModel
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@Composable
fun GameScreen(
    modifier: Modifier = Modifier,
    viewModel: GameViewModel = viewModel()
    ) {

    val gameUiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current
    // scope
    val scope = rememberCoroutineScope()
    // datastore Email
    val dataStore = StoreUserEmail(context)
    // get saved email
    val savedEmail = dataStore.getEmail.collectAsState(initial = "")

    var email = gameUiState.currendCard

    fun bicis(name:Preferences): String {
        val ramon = name.toString()
        return ramon
    }


    Column( modifier = modifier
       .padding(16.dp),
       verticalArrangement = Arrangement.spacedBy(8.dp)) {
       Button(
           modifier = modifier
               .width(151.dp)
               .height(70.dp)
               .padding(start = 8.dp),
           onClick = {   scope.launch {
               viewModel.resetGame()
               dataStore.saveEmail(viewModel.cards())
               viewModel.checkUserGuess()
           } }
       ) {
           Text(text = "Hulk", fontSize = 18.sp)
       }
       WellnesTaskList(list = gameUiState.currentCards)
   }
}




@ExperimentalFoundationApi
@Composable
fun WellnesTaskList(
    list: MutableSet<String>,
    modifier: Modifier = Modifier
){
    LazyColumn(modifier = Modifier) {
        list.forEach { item ->
                stickyHeader { wellnessTaskItem(taskName = "it $item") }
            }
    }
}


@Composable
fun wellnessTaskItem(
    taskName:String,
    modifier: Modifier = Modifier
){
    Card(
        modifier = Modifier
            .width(151.dp)
            .height(190.dp)
            .padding(8.dp)
            .clickable {

            },
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = taskName, fontSize = 18.sp)
        }
    }

}






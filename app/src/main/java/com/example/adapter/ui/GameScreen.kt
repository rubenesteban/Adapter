package com.example.adapter.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.adapter.Data.Directory
import com.example.adapter.GameViewModel

@Composable
fun GameScreen(
    modifier: Modifier = Modifier,
    viewModel: GameViewModel = viewModel()
    ) {
   Column(modifier = modifier) {
       WellnesTaskList(list = viewModel.tasks)
   }
}

@Composable
fun WellnesTaskList(
    list: List<Directory>,
    modifier: Modifier = Modifier
){
    LazyColumn(modifier = Modifier) {
        items(items = list, key = { task -> task.id}){
                task -> wellnessTaskItem(taskName = task.name) }
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


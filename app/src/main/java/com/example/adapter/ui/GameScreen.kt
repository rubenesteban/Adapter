package com.example.adapter.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.adapter.GameViewModel

@ExperimentalFoundationApi
@Composable
fun GameScreen(
    modifier: Modifier = Modifier,
    gameViewModel: GameViewModel = viewModel()
) {
    val gameUiState by gameViewModel.uiState.collectAsState()
    Column(
        modifier = modifier
            .padding(1.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(
            modifier = modifier
                .fillMaxWidth(0.3F)
                .weight(1f)
                .padding(start = 8.dp),
            onClick = { gameViewModel.updaState ()  }
        ) {
            Text(text = "iter", fontSize = 18.sp)
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 1.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            LazyGridList(
                options = gameUiState.currendCards
            )
            LazyGridList(
                options = gameUiState.currendCards
            )
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun LazyGridList(
    modifier: Modifier = Modifier,
    options: String
){
    LazyColumn(
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        options.forEach {
                item ->
            stickyHeader {
                Card(
                    modifier =Modifier
                        .width(151.dp)
                        .height(190.dp)
                        .padding(8.dp)
                        .clickable{

                        },
                    elevation = 10.dp
                ){
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Text(text = "item $item", fontSize = 18.sp)
                    }
                }
            }

        }
    }

}

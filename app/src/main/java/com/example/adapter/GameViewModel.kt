package com.example.adapter

import android.provider.ContactsContract
import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adapter.Data.Directory
import com.example.adapter.Data.GameUiState
import com.example.adapter.Data.StoreUserEmail
import com.example.adapter.Data.allCards
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {

   private val _uiState = MutableStateFlow(GameUiState())
   val uiState: StateFlow<GameUiState> =_uiState.asStateFlow()

    private var UsaWord: Set<String> = getallWords().toMutableSet()
    private var Words: MutableSet<String> = mutableSetOf()

    private lateinit var currentTask:String



    init {
        //resetGame()
        val result = viewModelScope.async {
            delay(300)
            true
        }
        result.invokeOnCompletion{
            if(it == null) {

            }
        }
    }
    private fun email(): String {
        currentTask = UsaWord.random()
        return currentTask
    }


    private fun pickRamdowTask(): MutableSet<String> {
        var i = 1
        while (i <=8){
            currentTask = UsaWord.random()
            Words.add(currentTask)
            i+=1
        }
        return Words
    }

    fun checkUserGuess(){
        _uiState.update { currentState ->
            currentState.copy(
                currendCard = email()
            )
        }
    }



    fun resetGame() {
       // Words.clear()
        _uiState.value = GameUiState(currentCards = pickRamdowTask())
    }

}



private fun getallWords(): Set<String> =
    setOf(
        "animal",
        "auto",
        "anecdote",
        "alphabet",
        "all",
        "awesome",
        "arise",
        "balloon",
        "basket",
        "bench",
        "best",
        "birthday",
        "book",
        "briefcase",
        "camera",
        "camping",
        "candle",
        "cat",
        "cauliflower",
        "chat",
        "children",
        "class",
        "classic",
        "classroom")
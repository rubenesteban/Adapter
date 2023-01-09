package com.example.adapter

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adapter.Data.GameUiState
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {

   private val _uiState = MutableStateFlow(GameUiState())
   val uiState: StateFlow<GameUiState> =_uiState.asStateFlow()

    private var UsaWord: Set<String> = getallWords().toMutableSet()
    private var Words: MutableSet<String> = mutableSetOf()

    private lateinit var currentTask:String


    init {
        //resetGame()
        val result = viewModelScope.async {
            delay(3000)
            true
        }
        result.invokeOnCompletion{
            if(it == null) {
                resetGame()

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
                currentCards = pickRamdowTask()
            )
        }
    }


    fun resetGame() {
        Words.clear()
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
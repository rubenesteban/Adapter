package com.example.adapter

import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.*
import com.example.adapter.Data.GameUiState
import com.example.adapter.Data.StoreUserEmail
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GameViewModel() : ViewModel() {

   private val _uiState = MutableStateFlow(GameUiState())
   val uiState: StateFlow<GameUiState> =_uiState.asStateFlow()

    private var UsaWord: Set<String> = getallWords().toMutableSet()
    private var Words: MutableSet<String> = mutableSetOf()
    private var Work: MutableSet<String> = mutableSetOf<String>("")

    private lateinit var currentTask:String
    private lateinit var tull:String




    init {
        //resetGame()
        val result = viewModelScope.async {
            delay(300)
            true
        }
        result.invokeOnCompletion{
            if(it == null) {
                resetGame()

            }
        }
    }
    
     fun cards(): String {
        currentTask = UsaWord.random()
        return currentTask
    }

    fun bicis(name: Preferences): String {
        val ramon = name.toString()
        return ramon
    }


    private fun pickRamdowTask(): MutableSet<String> {
        var i = 1
        while (i <=8){
            currentTask = cards()
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
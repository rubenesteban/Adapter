package com.example.adapter

import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.*
import com.example.adapter.Data.GameUiState
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel() : ViewModel() {

   private val _uiState = MutableStateFlow(GameUiState())
   val uiState: StateFlow<GameUiState> =_uiState.asStateFlow()

    private var UsaWord: Set<String> = getallWords().toMutableSet()
    private var Words: MutableSet<String> = mutableSetOf<String>("")
    private var Work: MutableSet<String> = mutableSetOf<String>("")
    private var Trabajo: MutableSet<String> = mutableSetOf<String>("")

    private lateinit var currentTask:String
    private lateinit var tull:String
    var pass:Boolean = true
    var tren:Boolean = true




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

    fun checkUser(){
        if(pass){
            _uiState.update { currentState ->
                currentState.copy(
                    currentCards = pickRamdowTask()
                )
            }

        }else{
            _uiState.update { currentState ->
                currentState.copy(
                    currentCards = petRamdowTask()
                )
            }
        }
        updatepass(pass)
    }

    fun updatepass(nime:Boolean){
        pass = !nime
    }




    private fun pickRamdowTask(): MutableSet<String> {
        Words.clear()
        var i = 1
        while (i <=5){
            currentTask = cards()
            Words.add(currentTask)
            i+=1
        }
        !tren
        return Words
    }

    fun repetir(tor: Boolean){
        tren=!tor
    }
    fun wordsfish():MutableSet<String> {
        if(tren) {
            Trabajo = pickRamdowTask()
        }
        repetir(tren)
        return Trabajo
    }

    private fun petRamdowTask(): MutableSet<String> {
        Work.clear()
        var i = 1
        while (i <=12){
            currentTask = cards()
            Work.add(currentTask)
            i+=1
        }
        return Work
    }

    fun checkUserGuess(){
        _uiState.update { currentState ->
            currentState.copy(
                usedCards = wordsfish()
            )
        }
    }


    fun resetGame() {
        Words.clear()
        Work.clear()
        //_uiState.value = GameUiState(currentCards = petRamdowTask())
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
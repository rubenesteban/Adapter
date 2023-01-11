package com.example.adapter

import android.util.Log
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.*
import com.example.adapter.Data.GameUiState
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
    private var Words: MutableSet<String> = mutableSetOf<String>("")
    private var Work: MutableSet<String> = mutableSetOf<String>("")
    private var Trabajo: MutableSet<String> = mutableSetOf<String>("")
    private var Fulliy: MutableSet<String> = mutableSetOf<String>("")
    private var Marcot: MutableSet<String> = mutableSetOf<String>("")

    private lateinit var currentTask:String
    private lateinit var Task:String
    private lateinit var tull:String
    var pass:Boolean = true
    var tren:Boolean = false
    private  val TAG: String = "UserPref"



    init {
        //Log.d(TAG, " it - $tren")

        //resetGame()

        probar(tren)
    }
    
     fun cards(): String {
        currentTask = UsaWord.random()
        return currentTask
    }

    private fun pickRamdowTask(): MutableSet<String> {
        Words.clear()
        var i = 1
        while (i <=27){
            currentTask = cards()
            Words.add(currentTask)
            i+=1
        }
        !tren
        return Words
    }



    fun wordsfish():MutableSet<String> {
        Trabajo = pickRamdowTask()
        return Trabajo
    }

   private fun probar(hulk:Boolean){
      if(!hulk) {
          Log.d(TAG, " it - $hulk")
          wordsfish()
      }
    }

    fun Cambio():MutableSet<String>{
        Marcot=UsaWord.toMutableSet()
        return Marcot
    }



    private suspend fun petRamdowTask(): MutableSet<String> {
            Work.clear()
            var i = 1
            while (i <= 27) {
                currentTask = cards()
                Work.add(currentTask)
                i += 1
            }
            Fulliy = (Cambio() - Work) as MutableSet<String>
            var y = Fulliy.size
            var u = 1
            var x = 27 - y
            while(u <= x  ) {
                Task = Fulliy.random()
                Work.add(Task)
                u += 1
            }
        return Work
    }


    fun checkUserGuess(){
        viewModelScope.launch {
            _uiState.update { currentState ->
                currentState.copy(
                    usedCards = petRamdowTask()
                )
            }
            Log.d(TAG, " it - $Work")
        }
    }

    fun UserGuess(){
        viewModelScope.launch {
            _uiState.update { currentState ->
                currentState.copy(
                    currentCards = Trabajo
                )
            }
           // Log.d(TAG, " it - $Work")
        }
    }


    fun resetGame() {
        Words.clear()
        Work.clear()
        Trabajo.clear()
       _uiState.value = GameUiState(usedCards = Work)
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
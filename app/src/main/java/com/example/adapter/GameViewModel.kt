package com.example.adapter

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.adapter.Data.GameUiState
import com.example.adapter.Data.allCards
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    private lateinit var currentCard: String

    private var userCards: MutableSet<String> = mutableSetOf()
    private var usedCards: MutableSet<String> = mutableSetOf()


    private var userGuess by mutableStateOf("")
        private set


    init {
        //updaState ()
        resetGame()
        //updaState ()
     // updateState (userCards)
      //  resetGame()
    }

    private fun pickRandomWordAndShuffle(): String {
        // Continue picking up a new random word until you get one that hasn't been used before
        currentCard = allCards.random()
        return  currentCard
    }

    private fun pickRandomCard():  MutableSet<String> {
        var num: Int = 1
        while (num <=7 ){
            allCards.forEach{
                item -> userCards.add(pickRandomWordAndShuffle())
                num += 1
            }
        }
        return userCards
    }

    private fun pickCard():  MutableSet<String> {
        var num: Int = 4
        while (num <=9 ){
            allCards.forEach{
                    item -> usedCards.add(pickRandomWordAndShuffle())
                num += 1
            }
        }
        return usedCards
    }


    fun resetGame() {
     _uiState.value = GameUiState(currendCards = "")
     _uiState.value = GameUiState(currendCards = pickRandomWordAndShuffle())
    }

   fun updateState( ) {
        _uiState.update { currentState ->
            currentState.copy(
                currendCards = pickRandomWordAndShuffle() )
        }
       resetGame()
    }

    fun updaState() {
        _uiState.value = GameUiState(currendCards = pickRandomWordAndShuffle())

    }

}
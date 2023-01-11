package com.example.adapter.Data

import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.LiveData

data class GameUiState(
    val currentCards: MutableSet<String> = mutableSetOf<String>(""),
    val currendCard: String = "",
    val usedCards: MutableSet<String> = mutableSetOf<String>("")
)
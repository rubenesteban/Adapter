package com.example.adapter.Data

data class GameUiState(
    val currentCards: MutableSet<String> = mutableSetOf(""),
    val currendCard: String = ""
)
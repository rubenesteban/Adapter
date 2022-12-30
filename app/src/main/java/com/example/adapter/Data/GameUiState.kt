package com.example.adapter.Data

data class GameUiState(
    var currentCards: MutableSet<String> = mutableSetOf(""),
    var currendCards: String = ""
)
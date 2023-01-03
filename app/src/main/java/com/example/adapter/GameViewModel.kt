package com.example.adapter

import android.provider.ContactsContract
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adapter.Data.Directory
import com.example.adapter.Data.GameUiState
import com.example.adapter.Data.allCards
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {

    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<Directory>
        get() = _tasks
   // private var usedTask:List<Directory> = getWellnessTasks().toMutableStateList()
    private var usedTask:MutableSet<String> = mutableSetOf()
    private lateinit var currentTask:String


    init {

    }
    fun pickRamdowTask(): MutableSet<String> {
        var i:Int = 1
        while (i <= 8) {
            currentTask = tasks.random().toString()
            usedTask.add(currentTask)
            i+=1
        }
        return usedTask
    }



}



private fun getWellnessTasks() = List(30) { i -> Directory(i, "Task # $i")}
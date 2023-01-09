package com.example.adapter.Data

import android.content.Context
import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.io.IOException

class StoreUserEmail(private val context: Context) {

    private val TAG: String = "User" +
            ""
    // to make sure there is only one instance
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("UserEmail")
        val USER_EMAIL_KEY = stringSetPreferencesKey("user_email")
    }

    // to get the email
    val getEmail: Flow<Any> = context.dataStore.data
        .catch {
            if (it is IOException) {
                it.printStackTrace()

                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        .map { preferences ->
            preferences[USER_EMAIL_KEY] ?: mutableSetOf<String>("")
        }


    // to save the email
    suspend fun saveEmail(name: MutableSet<String>) {
        context.dataStore.edit { preferences ->
            preferences[USER_EMAIL_KEY] = name
            Log.d(TAG, "onCreate:$name")
        }
    }
    suspend fun fetchInitialPreferences() = context.dataStore.data.first()
}

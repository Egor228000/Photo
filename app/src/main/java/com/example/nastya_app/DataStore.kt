package com.example.nastya_app

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class UserStore(
    val context: Context
) {
    companion object {
        val Context.dataStore: DataStore<Preferences> by preferencesDataStore("userToken")
        private val EMAIL = stringPreferencesKey("email")
        private val PASSWORD = stringPreferencesKey("password")
    }

    val getAccetToken_1: Flow<String> = context.dataStore.data
        .map { preferences ->
            preferences[EMAIL] ?: ""

        }
    suspend fun saveToken_1(token_1: String){
        context.dataStore.edit { preferences ->
            preferences[EMAIL] = token_1

        }
    }

    val getAccetToken_2: Flow<String> = context.dataStore.data
    .map { preferences ->
        preferences[PASSWORD] ?: ""

    }
    suspend fun saveToken_2(token_2: String){
        context.dataStore.edit { preferences ->
            preferences[PASSWORD] = token_2

        }
    }
}
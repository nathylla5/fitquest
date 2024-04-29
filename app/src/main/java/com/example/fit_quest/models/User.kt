package com.example.fit_quest.models

import androidx.compose.runtime.MutableState

data class User(
    val email: MutableState<String>,
    val password: MutableState<String>
)
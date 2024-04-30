package com.example.fit_quest.util

sealed class Route(val route: String) {
    object Login : Route("login")
    object SignUp : Route("signup")
    object Home : Route("home")
    object Training : Route("training")
    object Exercise : Route("exercise")
    object CreateExercise : Route("create_exercise")
    object CreateTraining : Route("create_training")
}
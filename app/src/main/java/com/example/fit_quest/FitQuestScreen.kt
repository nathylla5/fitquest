package com.example.fit_quest

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fit_quest.ui.modules.pages.Exercise
import com.example.fit_quest.ui.modules.pages.Home
import com.example.fit_quest.ui.modules.pages.Login
import com.example.fit_quest.ui.modules.pages.SignUp
import com.example.fit_quest.ui.modules.pages.Training
import com.example.fit_quest.util.Route

@Composable
fun FitQuestScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Route.Login.route) {
        composable(Route.Home.route) {
            Home(
                onSignOut = {
                    navController.navigate(Route.Login.route){
                        navController.popBackStack(Route.Home.route, true)
                    }
                },
                onCardTrainingClick = {
                    navController.navigate(Route.Training.route)
                }
            )
        }
        composable(Route.Login.route) {
            Login(
                onLogin = {
                    navController.navigate(Route.Home.route){
                        navController.popBackStack(Route.Login.route, true)
                    }
                },
                onSignClick = {
                    navController.navigate("signUp")
                },
                onGoogleClick = {

                }
            )
        }
        composable(Route.SignUp.route) {
            SignUp(
                onSignUp = {
                    navController.navigate(Route.Home.route){
                        navController.popBackStack(Route.SignUp.route, true)
                    }
                },
                onLoginClick = {
                    navController.popBackStack()
                }
            )
        }
        composable(Route.Training.route) {
            Training(
                onBackTrainingClick = {
                    navController.popBackStack()
                },
                onCardExerciseClick = {
                    navController.navigate(Route.Exercise.route)
                }
            )
        }
        composable(Route.Exercise.route) {
            Exercise(
                onBackTrainingClick = {
                    navController.popBackStack()
                },
               onClickGoNext = {}
            )
        }
    }
}
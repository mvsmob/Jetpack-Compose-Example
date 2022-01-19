package com.mandarine.jetpackcomposeexample.presentation.screens

sealed class Screen(val route: String) {
    object Splash: Screen("splash_screen")
    object Main: Screen("main")
    object SecondScreen: Screen("second_screen")
}

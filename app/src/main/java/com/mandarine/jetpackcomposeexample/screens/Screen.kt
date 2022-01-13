package com.mandarine.jetpackcomposeexample.screens

sealed class Screen(val route: String) {
    object Main: Screen("main")
    object SecondScreen: Screen("second_screen")
}

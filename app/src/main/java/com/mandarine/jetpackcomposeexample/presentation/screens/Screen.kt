package com.mandarine.jetpackcomposeexample.presentation.screens

sealed class Screen(val route: String) {
    object Splash: Screen("splash_screen")
    object Onboarding: Screen("onboarding")
    object Post: Screen("post_screen")
}

package com.mandarine.jetpackcomposeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mandarine.jetpackcomposeexample.presentation.screens.Screen
import com.mandarine.jetpackcomposeexample.presentation.screens.main.MainScreen
import com.mandarine.jetpackcomposeexample.presentation.screens.second_screen.SecondScreen
import com.mandarine.jetpackcomposeexample.ui.theme.JetpackComposeExampleTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val startRoute = Screen.Main.route
        setContent {
            JetpackComposeExampleTheme {
                Surface(color = MaterialTheme.colors.background) {
                    navController = rememberNavController()
                    NavHost(navController = navController, startDestination = startRoute) {
                        composable(route = Screen.Main.route) { MainScreen(navController = navController) }
                        composable(route = Screen.SecondScreen.route) { SecondScreen() }
                    }
                }
            }
        }
    }
}
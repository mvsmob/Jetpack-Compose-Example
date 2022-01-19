package com.mandarine.jetpackcomposeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mandarine.jetpackcomposeexample.presentation.screens.Screen
import com.mandarine.jetpackcomposeexample.presentation.screens.SplashScreen
import com.mandarine.jetpackcomposeexample.presentation.screens.main.MainScreen
import com.mandarine.jetpackcomposeexample.presentation.screens.second_screen.SecondScreen
import com.mandarine.jetpackcomposeexample.ui.theme.JetpackComposeExampleTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeExampleTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation() {
    val startRoute = Screen.Splash.route

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startRoute) {
        composable(route = Screen.Splash.route) { SplashScreen(navController = navController) }
        composable(route = Screen.Main.route) { MainScreen(navController = navController) }
        composable(route = Screen.SecondScreen.route) { SecondScreen() }
    }
}
package com.mandarine.jetpackcomposeexample.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.mandarine.jetpackcomposeexample.presentation.screens.common.LottieExample
import com.mandarine.jetpackcomposeexample.presentation.screens.splash.SplashScreenViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.compose.get

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashScreenViewModel = get()
) {

    val composableScope = rememberCoroutineScope()

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        LottieExample()
        composableScope.launch {
            delay(2000L)
            navController.navigate(viewModel.nextRoute) {
                popUpTo(0)
            }
        }
    }
}
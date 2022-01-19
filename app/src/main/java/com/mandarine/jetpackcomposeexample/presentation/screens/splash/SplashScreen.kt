package com.mandarine.jetpackcomposeexample.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.*
import com.mandarine.jetpackcomposeexample.R
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

@Composable
fun LottieExample() {

    val compositionResult: LottieCompositionResult = rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.momorun)
    )
    val progress by animateLottieCompositionAsState(
        composition = compositionResult.value,
        isPlaying = true,
        iterations = LottieConstants.IterateForever,
        speed = 1.0f
    )

    LottieAnimation(
        composition = compositionResult.value,
        progress = progress,
        modifier = Modifier.padding(all = 12.dp)
    )
}
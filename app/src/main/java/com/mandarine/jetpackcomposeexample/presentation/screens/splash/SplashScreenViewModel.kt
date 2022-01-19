package com.mandarine.jetpackcomposeexample.presentation.screens.splash

import androidx.lifecycle.ViewModel
import com.mandarine.jetpackcomposeexample.domain.use_case.splash.ChooseNextRouteUseCase

class SplashScreenViewModel(private val chooseNextRouteUseCase: ChooseNextRouteUseCase) :
    ViewModel() {

    val nextRoute: String = chooseNextRouteUseCase.nextRoute
}
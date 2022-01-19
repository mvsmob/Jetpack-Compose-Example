package com.mandarine.jetpackcomposeexample.domain.use_case.splash

import com.mandarine.jetpackcomposeexample.domain.repository.PreferenceRepository
import com.mandarine.jetpackcomposeexample.presentation.screens.Screen

class ChooseNextRouteUseCase(private val preferenceRepository: PreferenceRepository) {

    private val shouldShowOnboarding: Boolean
        get() = preferenceRepository.completedOnboarding

    val nextRoute: String = if (shouldShowOnboarding) Screen.SecondScreen.route
    else Screen.Main.route
}
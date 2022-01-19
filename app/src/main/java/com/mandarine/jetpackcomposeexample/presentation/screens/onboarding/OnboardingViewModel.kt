package com.mandarine.jetpackcomposeexample.presentation.screens.onboarding

import androidx.lifecycle.ViewModel
import com.mandarine.jetpackcomposeexample.domain.use_case.onboarding.CompleteOnboardingUseCase

class OnboardingViewModel(private val completeOnboardingUseCase: CompleteOnboardingUseCase) :
    ViewModel() {

    fun completeOnboarding() {
        completeOnboardingUseCase.completeOnboarding()
    }
}
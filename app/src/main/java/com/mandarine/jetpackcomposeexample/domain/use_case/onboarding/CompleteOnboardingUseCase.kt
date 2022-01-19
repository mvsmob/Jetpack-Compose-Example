package com.mandarine.jetpackcomposeexample.domain.use_case.onboarding

import com.mandarine.jetpackcomposeexample.domain.repository.PreferenceRepository

class CompleteOnboardingUseCase(private val preferenceRepository: PreferenceRepository) {

    fun completeOnboarding() {
        preferenceRepository.completedOnboarding = true
    }
}
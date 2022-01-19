package com.mandarine.jetpackcomposeexample.data.repository

import android.content.SharedPreferences
import com.mandarine.jetpackcomposeexample.domain.repository.PreferenceRepository

class PreferenceRepositoryImpl(private val preferences: SharedPreferences?): PreferenceRepository {

    override var completedOnboarding: Boolean
        get() = preferences?.getBoolean("COMPLETED_ONBOARDING", false) ?: false
        set(value) {
            preferences?.edit()?.putBoolean("COMPLETED_ONBOARDING", value)?.apply()
        }
}
package com.mandarine.jetpackcomposeexample.di

import com.mandarine.jetpackcomposeexample.screens.main.MainViewModel
import com.mandarine.jetpackcomposeexample.screens.second_screen.SecondScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<MainViewModel>{
        MainViewModel()
    }

    viewModel<SecondScreenViewModel>{
        SecondScreenViewModel()
    }
}
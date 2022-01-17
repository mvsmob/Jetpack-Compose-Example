package com.mandarine.jetpackcomposeexample.di

import com.mandarine.jetpackcomposeexample.data.remote.network.ApiInterface
import com.mandarine.jetpackcomposeexample.data.remote.network.ApiInterfaceImpl
import com.mandarine.jetpackcomposeexample.data.remote.repository.PostRepository
import com.mandarine.jetpackcomposeexample.data.remote.repository.PostRepositoryImpl
import com.mandarine.jetpackcomposeexample.data.use_case.posts.GetPostsUseCase
import com.mandarine.jetpackcomposeexample.screens.main.MainViewModel
import com.mandarine.jetpackcomposeexample.screens.second_screen.SecondScreenViewModel
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<MainViewModel>{
        MainViewModel()
    }

    viewModel<SecondScreenViewModel>{
        SecondScreenViewModel(getPostsUseCase = get())
    }

    factory<GetPostsUseCase> {
        GetPostsUseCase(repository = get())
    }

    single<ApiInterface> {
        ApiInterfaceImpl(
            client = HttpClient(Android) {
                install(Logging) {
                    level = LogLevel.ALL
                }
                install(JsonFeature) {
                    serializer = KotlinxSerializer()
                }
            }
        )
    }

    single<PostRepository>{
        PostRepositoryImpl(api = get())
    }
}
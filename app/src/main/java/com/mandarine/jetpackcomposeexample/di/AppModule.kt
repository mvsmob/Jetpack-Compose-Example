package com.mandarine.jetpackcomposeexample.di

import com.mandarine.jetpackcomposeexample.data.remote.network.ApiInterface
import com.mandarine.jetpackcomposeexample.data.remote.network.ApiInterfaceImpl
import com.mandarine.jetpackcomposeexample.data.repository.PostRepositoryImpl
import com.mandarine.jetpackcomposeexample.domain.repository.PostRepository
import com.mandarine.jetpackcomposeexample.domain.use_case.posts.GetPostsUseCase
import com.mandarine.jetpackcomposeexample.presentation.screens.main.MainViewModel
import com.mandarine.jetpackcomposeexample.presentation.screens.second_screen.SecondScreenViewModel
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
}

val dataModule = module {

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

val domainModule = module {

    factory<GetPostsUseCase> {
        GetPostsUseCase(repository = get())
    }
}
package com.mandarine.jetpackcomposeexample.screens.second_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mandarine.jetpackcomposeexample.data.use_case.Resource
import com.mandarine.jetpackcomposeexample.data.use_case.posts.GetPostsUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class SecondScreenViewModel(private val getPostsUseCase: GetPostsUseCase) : ViewModel() {

    private val _state = mutableStateOf<PostState>(PostState())
    val state: State<PostState> = _state

    init {
        getPostsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = PostState(posts = result.data)
                }
                is Resource.Error -> {
                    _state.value = PostState(error = result.message ?: "Something went wrong")
                }
                is Resource.Loading -> {
                    _state.value = PostState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
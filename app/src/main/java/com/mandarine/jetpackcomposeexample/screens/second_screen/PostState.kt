package com.mandarine.jetpackcomposeexample.screens.second_screen

import com.mandarine.jetpackcomposeexample.data.remote.dto.PostResponse

data class PostState(
    val isLoading: Boolean = false,
    val posts: List<PostResponse>? = emptyList(),
    val error: String = ""
)
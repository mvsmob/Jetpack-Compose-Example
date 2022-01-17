package com.mandarine.jetpackcomposeexample.domain.repository

import com.mandarine.jetpackcomposeexample.data.remote.dto.PostResponse

interface PostRepository {

    suspend fun getPosts(): List<PostResponse>
}
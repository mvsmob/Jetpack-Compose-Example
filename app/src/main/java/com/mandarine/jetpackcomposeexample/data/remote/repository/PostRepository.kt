package com.mandarine.jetpackcomposeexample.data.remote.repository

import com.mandarine.jetpackcomposeexample.data.remote.dto.PostResponse
import com.mandarine.jetpackcomposeexample.data.remote.network.ApiInterface

interface PostRepository {

    suspend fun getPosts(): List<PostResponse>
}

class PostRepositoryImpl (private val api: ApiInterface) : PostRepository {

    override suspend fun getPosts(): List<PostResponse> {
        return api.getPosts()
    }
}
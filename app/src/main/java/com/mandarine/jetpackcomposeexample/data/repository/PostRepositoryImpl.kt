package com.mandarine.jetpackcomposeexample.data.repository

import com.mandarine.jetpackcomposeexample.data.remote.dto.PostResponse
import com.mandarine.jetpackcomposeexample.data.remote.network.ApiInterface
import com.mandarine.jetpackcomposeexample.domain.repository.PostRepository

class PostRepositoryImpl (private val api: ApiInterface) : PostRepository {

    override suspend fun getPosts(): List<PostResponse> {
        return api.getPosts()
    }
}
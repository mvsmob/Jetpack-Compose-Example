package com.mandarine.jetpackcomposeexample.data.remote.network

import com.mandarine.jetpackcomposeexample.data.remote.dto.PostResponse

interface ApiInterface {

    suspend fun getPosts(): List<PostResponse>
}
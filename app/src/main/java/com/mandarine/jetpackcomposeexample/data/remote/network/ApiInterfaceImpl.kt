package com.mandarine.jetpackcomposeexample.data.remote.network

import com.mandarine.jetpackcomposeexample.common.Constants
import com.mandarine.jetpackcomposeexample.data.remote.dto.PostResponse
import io.ktor.client.*
import io.ktor.client.request.*

class ApiInterfaceImpl(private val client: HttpClient) : ApiInterface {

    override suspend fun getPosts(): List<PostResponse> {
        return client.get { url(Constants.POSTS) }
    }
}
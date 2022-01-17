package com.mandarine.jetpackcomposeexample.domain.use_case.posts

import com.mandarine.jetpackcomposeexample.data.remote.dto.PostResponse
import com.mandarine.jetpackcomposeexample.common.Resource
import com.mandarine.jetpackcomposeexample.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class GetPostsUseCase(private val repository: PostRepository) {

    operator fun invoke(): Flow<Resource<List<PostResponse>>> = flow {
        try {
            emit(Resource.Loading<List<PostResponse>>())
            val posts: List<PostResponse> = repository.getPosts()
            emit(Resource.Success<List<PostResponse>>(posts))
        } catch (e: IOException) {
            emit(Resource.Error<List<PostResponse>>(message = "Couldn't reach server."))
        }
    }
}
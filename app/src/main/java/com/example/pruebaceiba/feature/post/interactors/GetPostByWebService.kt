package com.example.pruebaceiba.feature.post.interactors

import com.example.pruebaceiba.core.basedomain.IExceptionHandler
import com.example.pruebaceiba.core.basedomain.Result
import com.example.pruebaceiba.core.basedomain.UseCase
import com.example.pruebaceiba.feature.post.domain.Post
import com.example.pruebaceiba.feature.post.domain.PostRepository
import com.example.pruebaceiba.feature.user.domain.User
import com.example.pruebaceiba.feature.user.domain.UserEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

class GetPostByWebService(
    var repository: PostRepository,
    exceptionHandler: IExceptionHandler,
    dispatcher: CoroutineDispatcher = Dispatchers.IO
) : UseCase<Int, List<Post>>(exceptionHandler, dispatcher) {


    override suspend fun performAction(param: Int): Flow<Result<List<Post>>>
    = repository.getAllPostByIdUser(param)


}
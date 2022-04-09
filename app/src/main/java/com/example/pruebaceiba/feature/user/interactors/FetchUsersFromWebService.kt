package com.example.pruebaceiba.feature.user.interactors

import com.example.pruebaceiba.core.basedomain.IExceptionHandler
import com.example.pruebaceiba.core.basedomain.Result
import com.example.pruebaceiba.core.basedomain.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class FetchUsersFromWebService(
    private val repository: UserRepository,
    exceptionHandler: IExceptionHandler,
    dispatcher: CoroutineDispatcher
) : UseCase<Unit, Boolean>(exceptionHandler, dispatcher) {

    override suspend fun performAction(param: Unit):Flow<Result<Boolean>> = repository.fetchUsersFromWeb()
}
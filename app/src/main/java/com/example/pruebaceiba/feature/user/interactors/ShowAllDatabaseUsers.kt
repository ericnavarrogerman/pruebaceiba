package com.example.pruebaceiba.feature.user.interactors

import com.example.pruebaceiba.core.basedomain.IExceptionHandler
import com.example.pruebaceiba.core.basedomain.UseCase
import com.example.pruebaceiba.feature.user.domain.User
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class ShowAllDatabaseUsers(
    private val repository: UserRepository,
    exceptionHandler: IExceptionHandler,
    dispatcher: CoroutineDispatcher
    ) :
    UseCase<Unit, Flow<List<User>>>(exceptionHandler, dispatcher) {

    override suspend fun performAction(param: Unit) = repository.getAllUserFromDb()
}
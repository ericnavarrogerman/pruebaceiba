package com.example.pruebaceiba.feature.user.interactors

import com.example.pruebaceiba.core.basedomain.IExceptionHandler
import com.example.pruebaceiba.core.basedomain.Result
import com.example.pruebaceiba.core.basedomain.UseCase
import com.example.pruebaceiba.core.basedomain.UseCaseWithoutParams
import com.example.pruebaceiba.feature.user.domain.User
import com.example.pruebaceiba.feature.user.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

class ValidateIfRequireFetch(
    private val repository: UserRepository,
    exceptionHandler: IExceptionHandler,
    dispatcher: CoroutineDispatcher = Dispatchers.IO
) :UseCaseWithoutParams<Boolean>(exceptionHandler, dispatcher) {

    override suspend fun performAction()  = repository.dbIsEmpty()
}
package com.example.pruebaceiba.feature.user.interactors

import kotlinx.coroutines.flow.Flow
import com.example.pruebaceiba.core.basedomain.Result
import com.example.pruebaceiba.feature.user.domain.User


class UserRepository(){


    suspend fun fetchUsersFromWeb(): Flow<Result<Boolean>> {
        TODO()
    }

    suspend fun getAllUserFromDb(): Flow<Result<Flow<List<User>>>> {
        TODO()
    }


}
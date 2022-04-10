package com.example.pruebaceiba.feature.user.repository.datasource.remote

import com.example.pruebaceiba.feature.user.domain.User
import com.example.pruebaceiba.feature.user.framework.UserService
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(
    var userService: UserService
) {
    suspend fun getAll(): List<User> {
        return userService.getAllUsers()
    }
}
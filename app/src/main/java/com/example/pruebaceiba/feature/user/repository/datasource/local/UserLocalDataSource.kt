package com.example.pruebaceiba.feature.user.repository.datasource.local

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.pruebaceiba.feature.user.domain.User
import com.example.pruebaceiba.feature.user.domain.UserEntity
import com.example.pruebaceiba.feature.user.framework.AppDatabase
import kotlinx.coroutines.flow.distinctUntilChanged
import javax.inject.Inject


class UserLocalDataSource @Inject constructor(application: Context) {

    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java, "database-users"
    ).build()

            fun findUserById(id:Int)=db.userDao().findUserById(id)

            fun findAllUsers()=db.userDao().findAllUser()

    suspend fun insertAllMovies(users:List<UserEntity>)=db.userDao().insertAllUsers(users)

            fun getTotalUserInDb()=db.userDao().getCount()



}
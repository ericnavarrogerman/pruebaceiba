package com.example.pruebaceiba.feature.user.framework

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pruebaceiba.feature.user.domain.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM Users WHERE id_web=:id")
    fun findUserById(id:Int):UserEntity

    @Query("SELECT * FROM Users ORDER BY id")
    fun findAllUser():List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllUsers( users: List<UserEntity>):List<Long>


    @Query("SELECT COUNT(id) FROM Users")
    fun getCount(): Int

}
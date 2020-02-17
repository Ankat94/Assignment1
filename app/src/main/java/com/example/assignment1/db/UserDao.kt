package com.example.assignment1.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Query("select * from user")
    fun loadAllUsers() : List<User>

    @Query("select * from user where uid = :id")
    fun loadUser(id: Int) : User

    @Delete
    fun delete(user: User)
}
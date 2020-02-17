package com.example.assignment1.repo

import com.example.assignment1.db.AppDatabase
import com.example.assignment1.db.User

class UserRepository(
    private val appDb: AppDatabase
) {

    fun saveUser(user: User) = appDb.getUserDao().insert(user)

    fun loadAllUser() = appDb.getUserDao().loadAllUsers()

    fun updateUser(user: User) = appDb.getUserDao().update(user)

    fun deleteUser(user: User) = appDb.getUserDao().delete(user)
}
package com.example.assignment1.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assignment1.db.AppDatabase
import com.example.assignment1.repo.UserRepository

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val userRepository: UserRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return InsertViewModel(userRepository) as T
    }
}
package com.example.assignment1.ui

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.assignment1.db.User
import com.example.assignment1.repo.UserRepository

class MainViewModel(private val userRepository: UserRepository): ViewModel() {

    var users: List<User>? = null
//    var mainListener: MainListener? = null

//    fun onAddClick(view: View) {
//        mainListener?.onFabClicked()
//    }

}
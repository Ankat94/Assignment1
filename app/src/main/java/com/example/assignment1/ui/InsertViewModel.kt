package com.example.assignment1.ui

import android.view.View
import android.widget.Button
import androidx.lifecycle.ViewModel
import com.example.assignment1.db.User
import com.example.assignment1.repo.UserRepository
import com.example.assignment1.util.Coroutines
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class InsertViewModel(
    private val userRepository: UserRepository
) : ViewModel() {

//    var name: String? = null
//    var age: String? = null
//    var email: String? = null

    var user: User? = null

    var operationListener: OperationListener? = null

    fun onInsertClick(view: View) {

        val button: Button = view as Button
        val text: String = button.text.toString()

        if (user?.name.isNullOrEmpty() || user?.age.isNullOrEmpty() || user?.email.isNullOrEmpty()) {
            operationListener?.onFailure("Please Enter All Data Properly!!")
            return
        }

        if (text.contentEquals("insert")) {
            Coroutines.main {
                userRepository.saveUser(user!!).also {
                    operationListener?.onInserted()
                }
            }
        }
        else {
            Coroutines.main {
                userRepository.updateUser(user!!).also {
                    operationListener?.onInserted()
                }
            }
        }

    }
}
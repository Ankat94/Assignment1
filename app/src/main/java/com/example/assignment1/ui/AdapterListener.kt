package com.example.assignment1.ui

import com.example.assignment1.db.User

interface AdapterListener {

    fun onDelete(user: User)
}
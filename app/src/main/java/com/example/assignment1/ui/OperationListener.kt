package com.example.assignment1.ui

interface OperationListener {

    fun onInserted()
    fun onLoadAll()
    fun onLoad()
    fun onFailure(message: String)
}
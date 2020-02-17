package com.example.assignment1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.assignment1.R
import com.example.assignment1.databinding.ActivityInsertUserBinding
import com.example.assignment1.db.AppDatabase
import com.example.assignment1.db.User
import com.example.assignment1.repo.UserRepository
import com.example.assignment1.util.toast

class InsertUser : AppCompatActivity(), OperationListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appDatabase = AppDatabase(this)
        val userRepository = UserRepository(appDatabase)
        val factory = ViewModelFactory(userRepository)

        val binding: ActivityInsertUserBinding = DataBindingUtil.setContentView(this,R.layout.activity_insert_user)
        val model = ViewModelProvider(this, factory).get(InsertViewModel::class.java)
        binding.viewmodel = model
        model.operationListener = this

        val type = intent.getIntExtra("OpType",0)
        if (type == 1)
        {
            binding.button.setText("insert")
            model.user = User()
        }
        else{
            binding.button.setText("update")
            val user = intent.extras?.get("User") as User
            model.user = user

        }
    }

    override fun onInserted() {
        finish()
    }

    override fun onLoadAll() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLoad() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFailure(message: String) {
      toast(message)
    }
}

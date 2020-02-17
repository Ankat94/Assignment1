package com.example.assignment1.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment1.R
import com.example.assignment1.databinding.ActivityMainBinding
import com.example.assignment1.db.AppDatabase
import com.example.assignment1.db.User
import com.example.assignment1.repo.UserRepository
import com.example.assignment1.util.Coroutines
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity(), AdapterListener {


    var userRepository: UserRepository? = null
        var model: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appDatabase = AppDatabase(this)
        userRepository = UserRepository(appDatabase)
        val factory = MainModelFactory(userRepository!!)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        model = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        mainLoad()

        binding.floatingActionButton2.setOnClickListener {  val intent = Intent(this,InsertUser::class.java)
            intent.putExtra("OpType",1)
            startActivity(intent) }
    }

    override fun onResume() {
        super.onResume()
        mainLoad()
    }

    fun mainLoad() {
        GlobalScope.async {
            model?.users = userRepository?.loadAllUser()
            launch(Dispatchers.Main) {
                main_recycle.also {
                    it.layoutManager = LinearLayoutManager(this@MainActivity)
                    it.setHasFixedSize(true)
                    it.adapter = UserAdapter(model?.users!!, this@MainActivity)
                }
                }
             }
    }

    override fun onDelete(user: User) {
        GlobalScope.async{
             userRepository?.deleteUser(user).also {
                 model?.users = userRepository?.loadAllUser()
                 launch (Dispatchers.Main) {
                     main_recycle.also {
                         it.adapter = UserAdapter(model?.users!!, this@MainActivity)
                     }
                 } }

         }
    }
}

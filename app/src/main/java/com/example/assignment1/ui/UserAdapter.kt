package com.example.assignment1.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment1.R
import com.example.assignment1.databinding.UserLayoutBinding
import com.example.assignment1.db.User
import java.io.Serializable

class UserAdapter(
    private val users: List<User>,
    private val context: Context,
    private val adapterListener: AdapterListener = context as AdapterListener
): RecyclerView.Adapter<UserAdapter.UserHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserHolder (DataBindingUtil.inflate<UserLayoutBinding>(
        LayoutInflater.from(parent.context),
        R.layout.user_layout,
        parent,
        false
    ))

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.userLayoutBinding.user = users[position]
        holder.userLayoutBinding.imageView.setOnClickListener {
            adapterListener.onDelete(users[position])
        }
        holder.userLayoutBinding.root.setOnClickListener {
            var intent = Intent(context,InsertUser::class.java).also {
                it.putExtra("OpType",2)
                it.putExtra("User",users[position] as Serializable)
                context.startActivity(it)
            }
        }
    }

    inner class UserHolder(
        val userLayoutBinding: UserLayoutBinding
    ): RecyclerView.ViewHolder(userLayoutBinding.root) {
    }
}
package com.example.assignment1.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class User(
    var name: String? = null,
    var age: String? = null,
    var email: String? = null
): Serializable {

    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}

package com.example.room

import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "user_list_table")
data class UserListTable(
    @PrimaryKey
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    //val address: Address?,
    val phone: String,
    val website: String,
   // val company: Company?
) {

}

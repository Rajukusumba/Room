package com.example.room


import androidx.room.Entity
import com.google.gson.annotations.SerializedName

data class UserItem(
    @SerializedName("address")
    val address: Address? = Address(),
    @SerializedName("company")
    val company: Company? = Company(),
    @SerializedName("email")
    val email: String? = "",
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("phone")
    val phone: String? = "",
    @SerializedName("username")
    val username: String? = "",
    @SerializedName("website")
    val website: String? = ""
)
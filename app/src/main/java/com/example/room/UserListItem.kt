package com.example.room



import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull

data class UserListItem(
    @SerializedName("address")
    val address: AddressX? = AddressX(),
    @SerializedName("company")
    val company: Company? = Company(),
    @SerializedName("email")
    val email: String? = "",
    @SerializedName("id")
    @PrimaryKey
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
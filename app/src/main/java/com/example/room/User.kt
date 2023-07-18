package com.example.roomdb

import android.os.Parcelable
import androidx.room.DatabaseView
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.room.Address
import com.example.room.Company
import kotlinx.parcelize.Parcelize
@Parcelize
@Entity("user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val firstName:String,
    val lastName:String,
    val age: String,
    var editMode:Boolean
):Parcelable {
}
//@Entity(tableName = "user_list_table")
//data class UserListTable(
//    @PrimaryKey
//    val id: Int,
//    val name: String,
//    val username: String,
//    val email: String,
//    val address: Address?,
//    val phone: String,
//    val website: String,
//    val company: Company?
//){
//
//}
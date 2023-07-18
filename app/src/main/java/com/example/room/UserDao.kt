package com.example.roomdb

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.room.UserList
import com.example.room.UserListItem
import com.example.room.UserListTable

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun addUser(user: User)

   @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllUsers():LiveData<List<User>>

//   @Query("SELECT FROM user_table")
//    suspend fun deleteAllUsers()

   @Delete
    suspend fun deleteUser(user: User)

    @Update()
    suspend fun updateUser(user:User)

//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun insertDataFromApi(userListItem: List<UserListItem>)

//    @Query("SELECT * FROM user_list_table ORDER BY id ASC")
//     fun readApiData():LiveData<List<UserListTable>>

}
package com.example.roomdb

import androidx.lifecycle.LiveData
import com.example.room.UserListItem

class UserRepository(private val userDao: UserDao) {

    val readAllDatas: LiveData<List<User>> = userDao.readAllUsers()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

    suspend fun deleteAllUsers(){
      //  userDao.deleteAllUsers()
    }
    suspend fun deleteUser(user: User){
        userDao.deleteUser(user)
    }

    suspend fun updateUser(user: User){
        userDao.updateUser(user)
    }

//    suspend fun insertDataFromApi(userListItem: List<UserListItem>){
//        userDao.insertDataFromApi(userListItem)
//    }




}
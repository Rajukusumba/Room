package com.example.roomdb

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.room.RetrofitInstance
import com.example.room.UserListItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    var readAllData: LiveData<List<User>>? = null

    // val readAllData: LiveData<List<UserListItem>> = TODO()


    private val repository: UserRepository


   init {
    //   var retrofitInstance:RetrofitInstance = RetrofitInstance()
        val userDao = UserDatabase.getDatabase(application).UserDao()
        repository = UserRepository(userDao)
        viewModelScope.launch {
                readAllData=repository.readAllDatas
        }

    }

    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user = user)
        }
    }

    fun deleteAllUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllUsers()
        }

    }

    fun updateUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(user)
        }
    }

    fun deleteUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUser(user)
        }
    }
}
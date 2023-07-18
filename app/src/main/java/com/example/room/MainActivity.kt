package com.example.roomdb

import android.R
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.example.room.RetrofitInstance
import com.example.room.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var retrofitInstance:RetrofitInstance
    lateinit var repository: UserRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        if (getSupportActionBar() != null) {
            getSupportActionBar()?.hide();
        }
        setContentView(binding.root)

        val userDao = UserDatabase.getDatabase(application).UserDao()
        repository = UserRepository(userDao)
       // var readAllData = repository.readAllData

          retrofitInstance = RetrofitInstance()

        GlobalScope.launch {
            val response = retrofitInstance.retrofit.getResponse()
            Log.d("logging", response.toString())
            if (response != null) {
                // readAllData=response
              //  repository.insertDataFromApi(response)

            }
           // Log.d("logging", userDao.readApiData().toString())
            // setContentView(R.layout.activity_main)
        }
    }
}
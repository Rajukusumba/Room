package com.example.room

import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getResponse(): List<UserListItem>
}
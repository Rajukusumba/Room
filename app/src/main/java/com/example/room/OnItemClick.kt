package com.example.room

import com.example.roomdb.User

interface OnItemClick {
    fun deleteUser(user: User)
}
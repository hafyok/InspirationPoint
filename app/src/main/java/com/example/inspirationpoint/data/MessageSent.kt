package com.example.inspirationpoint.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MessageSent(
    @PrimaryKey val id: Int,
    val time: Long,
    val date: String,
    val author: String,
    val text: String
)

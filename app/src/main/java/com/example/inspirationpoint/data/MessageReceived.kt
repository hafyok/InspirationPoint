package com.example.inspirationpoint.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MessageReceived(
    @PrimaryKey val id: Int,
    val time: Long,
    val date: String,
    val recepient: String,
    val text: String
)

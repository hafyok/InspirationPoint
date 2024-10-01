package com.example.inspirationpoint.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class MessageReceived(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val time: Long,
    val date: Date,
    val recepient: String,
    val text: String
)

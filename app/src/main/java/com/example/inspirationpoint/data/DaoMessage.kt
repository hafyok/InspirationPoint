package com.example.inspirationpoint.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DaoMessage {
    @Query("SELECT * FROM messagereceived")
    suspend fun getAllMessageReceived(): List<MessageReceived>

    @Query("SELECT * FROM messagesent")
    suspend fun getAllMessageSent(): List<MessageSent>

    @Insert
    suspend fun insertMessageSent(messageSent: MessageSent)

    @Insert
    suspend fun insertMessageReceived(messageReceived: MessageReceived)
}
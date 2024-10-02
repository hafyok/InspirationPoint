package com.example.inspirationpoint.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoMessage {
    @Query("SELECT * FROM messagereceived")
    fun getAllMessageReceived(): Flow<List<MessageReceived>>

    @Query("SELECT * FROM messagesent")
    fun getAllMessageSent(): Flow<List<MessageSent>>

    @Insert
    fun insertMessageSent(messageSent: MessageSent)

    @Insert
    fun insertMessageReceived(messageReceived: MessageReceived)
}
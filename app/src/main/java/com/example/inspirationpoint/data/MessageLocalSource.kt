package com.example.inspirationpoint.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MessageLocalSource @Inject constructor(private val daoMessage: DaoMessage) {
    fun getAllMessageReceived(): Flow<List<MessageReceived>>{
        return daoMessage.getAllMessageReceived()
    }

    fun getAllMessageSent(): Flow<List<MessageSent>>{
        return daoMessage.getAllMessageSent()
    }

    fun insertMessageSent(messageSent: MessageSent){
        daoMessage.insertMessageSent(messageSent)
    }

    fun insertMessageReceived(messageReceived: MessageReceived){
        daoMessage.insertMessageReceived(messageReceived)
    }
}
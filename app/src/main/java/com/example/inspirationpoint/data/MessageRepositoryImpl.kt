package com.example.inspirationpoint.data

import javax.inject.Inject


class MessageRepositoryImpl @Inject constructor(private val messageSource: MessageLocalSource) {
    val messagesSent = messageSource.getAllMessageSent()
    val messagesReceived = messageSource.getAllMessageReceived()

    fun insertMessageSent(messageSent: MessageSent) {
        messageSource.insertMessageSent(messageSent)
    }

    fun insertMessageReceived(messageReceived: MessageReceived) {
        messageSource.insertMessageReceived(messageReceived)
    }
}
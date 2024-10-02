package com.example.inspirationpoint.data


class MessageRepositoryImpl(private val messageSource: MessageLocalSource) {
    val messagesSent = messageSource.getAllMessageSent()
    val messagesReceived = messageSource.getAllMessageReceived()

    fun insertMessageSent(messageSent: MessageSent) {
        messageSource.insertMessageSent(messageSent)
    }

    fun insertMessageReceived(messageReceived: MessageReceived) {
        messageSource.insertMessageReceived(messageReceived)
    }
}
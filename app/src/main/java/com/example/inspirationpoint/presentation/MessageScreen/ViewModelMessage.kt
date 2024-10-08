package com.example.inspirationpoint.presentation.MessageScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.inspirationpoint.data.MessageReceived
import com.example.inspirationpoint.data.MessageRepositoryImpl
import com.example.inspirationpoint.data.MessageSent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ViewModelMessage @Inject constructor (private val repository: MessageRepositoryImpl): ViewModel() {
    val messagesSent: LiveData<List<MessageSent>> = repository.messagesSent.asLiveData()
    val messagesReceived: LiveData<List<MessageReceived>> = repository.messagesReceived.asLiveData()

    fun insertSent(messageSent: MessageSent) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            repository.insertMessageSent(messageSent)
        }
    }

    fun insertReceived(messageReceived: MessageReceived) = viewModelScope.launch {
        withContext(Dispatchers.IO){
            repository.insertMessageReceived(messageReceived)
        }
    }
}
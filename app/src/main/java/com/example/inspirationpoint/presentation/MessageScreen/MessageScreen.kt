package com.example.inspirationpoint.presentation.MessageScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MessageScreen(
    modifier: Modifier = Modifier,
    viewModelMessage: ViewModelMessage = hiltViewModel()
) {
    val messageSent by viewModelMessage.messagesSent.observeAsState(initial = emptyList())
    val messageReceived by viewModelMessage.messagesReceived.observeAsState(initial = emptyList())
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp), // Общий отступ для экрана
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Messages",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Divider()

        // Имя и Период
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Name: Dmitrii", style = MaterialTheme.typography.bodySmall)
            Text(text = "Period: Today", style = MaterialTheme.typography.bodySmall)
        }

        HorizontalDivider()

        // Раздел "Received"
        MessageReceived(messageReceived)

        MessageSent(messageSent)

        MessageNew(
            onClickSent = { message -> viewModelMessage.insertSent(message) },
            onClickReceived = { message -> viewModelMessage.insertReceived(message) })
    }
}

// Функции для отображения текста в ячейках таблиц
@Composable
fun TableHeaderText(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier
            //.weight(1f)
            .padding(horizontal = 8.dp)
    )
}

@Composable
fun TableRowText(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier
            //.weight(1f)
            .padding(horizontal = 8.dp)
    )
}

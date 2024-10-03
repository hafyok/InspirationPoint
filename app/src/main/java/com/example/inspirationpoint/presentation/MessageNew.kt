package com.example.inspirationpoint.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.inspirationpoint.data.MessageReceived
import com.example.inspirationpoint.data.MessageSent
import java.util.Calendar


@Composable
fun MessageNew(
    onClickSent: (messageSent: MessageSent) -> Unit,
    onClickReceived: (messageReceived: MessageReceived) -> Unit
) {
    var textRecepient by remember { mutableStateOf("") }
    var textSent by remember { mutableStateOf("") }

    // Новый сообщение
    Text(
        text = "New",
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.padding(vertical = 8.dp)
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextField(
            value = textRecepient,
            onValueChange = { textRecepient = it },
            label = { Text("Recipient") },
            modifier = Modifier.weight(1f)
        )
    }
    TextField(
        value = textSent,
        onValueChange = { textSent = it },
        label = { Text("Text") },
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    )
    Button(
        onClick = {
            val messageSent = MessageSent(
                0,
                System.currentTimeMillis(),
                Calendar.getInstance().time,
                "Manager",
                textSent
            )
            val messageReceived = MessageReceived(
                0,
                System.currentTimeMillis(),
                Calendar.getInstance().time,
                textRecepient,
                textSent
            )
            onClickSent(messageSent)
            onClickReceived(messageReceived)
        },
        modifier = Modifier.padding(top = 16.dp)
    ) {
        Text("Send")
    }
}
package com.example.inspirationpoint

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MessageNew(){
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
            value = "",
            onValueChange = {},
            label = { Text("Recipient") },
            modifier = Modifier.weight(1f)
        )
    }
    TextField(
        value = "",
        onValueChange = {},
        label = { Text("Text") },
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    )
    Button(
        onClick = { /* TODO */ },
        modifier = Modifier.padding(top = 16.dp)
    ) {
        Text("Send")
    }
}
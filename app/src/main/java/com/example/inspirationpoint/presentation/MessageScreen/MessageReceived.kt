package com.example.inspirationpoint.presentation.MessageScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.inspirationpoint.data.MessageReceived
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun MessageReceived(listMessage: List<MessageReceived>){
    Text(
        text = "Received",
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.padding(vertical = 16.dp),
    )

    // Таблица с данными
    Column(modifier = Modifier.fillMaxWidth().height(120.dp)) {
        // Заголовки
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TableHeaderText(text = "#")
            TableHeaderText(text = "Time")
            TableHeaderText(text = "Date")
            TableHeaderText(text = "Author")
            TableHeaderText(text = "Text")
        }
        HorizontalDivider()
        LazyColumn {
            items(listMessage){
                    item ->
                ItemRecordReceived(message = item)
            }
        }
    }
}

@Composable
fun ItemRecordReceived(message: MessageReceived){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TableRowText(text = message.id.toString())
        TableRowText(text = SimpleDateFormat("HH:mm:ss").format(Date(message.time)).toString())
        TableRowText(text = SimpleDateFormat("dd.MM.yyyy").format(message.date))
        TableRowText(text = message.recepient)
        TableRowText(text = message.text)
    }
    HorizontalDivider()
}

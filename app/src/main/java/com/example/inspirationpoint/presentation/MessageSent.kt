package com.example.inspirationpoint.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableOpenTarget
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.inspirationpoint.data.MessageSent
import kotlinx.coroutines.flow.merge
import java.util.Calendar
import java.util.Date

@Composable
fun MessageSent(listMessage: List<MessageSent>){
    Text(
        text = "Sent",
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.padding(vertical = 16.dp),
    )

    // Таблица с данными
    Column(modifier = Modifier.fillMaxWidth()) {
        // Заголовки
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TableHeaderText(text = "#")
            TableHeaderText(text = "Time")
            TableHeaderText(text = "Date")
            TableHeaderText(text = "Recepient")
            TableHeaderText(text = "Text")
        }
        HorizontalDivider()
        // Строки данных

        LazyColumn {
            items(listMessage){
                item ->
                ItemRecord(message = item)
            }
        }
        /*repeat(2) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TableRowText(text = "105")
                TableRowText(text = "13:26:20")
                TableRowText(text = "03.12.2022")
                TableRowText(text = "Dmitrii")
                TableRowText(text = "CAM-05 is down")
            }
            HorizontalDivider()
        }*/
    }
}

@Composable
fun ItemRecord (message: MessageSent){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TableRowText(text = message.id.toString())
        TableRowText(text = Date(message.time).toString())
        TableRowText(text = message.date.toString())
        TableRowText(text = message.author)
        TableRowText(text = message.text)
    }
    HorizontalDivider()
}
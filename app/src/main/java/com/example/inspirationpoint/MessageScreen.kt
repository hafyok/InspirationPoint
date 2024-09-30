package com.example.inspirationpoint

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MessageScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp), // Padding для всего экрана
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Заголовок
        Text(
            text = "Messages",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        HorizontalDivider()

        // Имя и Период
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Name: Dmitrii", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Period: Today", style = MaterialTheme.typography.bodyLarge)
        }
        HorizontalDivider()

        // Раздел "Received"
        Text(
            text = "Received",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            TableHeaderText(text = "#")
            TableHeaderText(text = "Time")
            TableHeaderText(text = "Date")
            TableHeaderText(text = "Author")
            TableHeaderText(text = "Text")
        }
        // Моковые данные
        Row(modifier = Modifier.fillMaxWidth()) {
            TableRowText(text = "245")
            TableRowText(text = "13:56:20")
            TableRowText(text = "03.12.2022")
            TableRowText(text = "Dmitrii")
            TableRowText(text = "Approve all LiveData")
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            TableRowText(text = "244")
            TableRowText(text = "13:54:07")
            TableRowText(text = "03.12.2022")
            TableRowText(text = "Dmitrii")
            TableRowText(text = "Check CAM-05")
        }
        HorizontalDivider()

        // Раздел "Sent"
        Text(
            text = "Sent",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            TableHeaderText(text = "#")
            TableHeaderText(text = "Time")
            TableHeaderText(text = "Date")
            TableHeaderText(text = "Recipient")
            TableHeaderText(text = "Text")
        }
        // Моковые данные
        Row(modifier = Modifier.fillMaxWidth()) {
            TableRowText(text = "105")
            TableRowText(text = "13:26:20")
            TableRowText(text = "03.12.2022")
            TableRowText(text = "Dmitrii")
            TableRowText(text = "CAM-05 is down")
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            TableRowText(text = "104")
            TableRowText(text = "13:14:07")
            TableRowText(text = "03.12.2022")
            TableRowText(text = "Anatolii")
            TableRowText(text = "Go to the piste 6")
        }
        HorizontalDivider()

        // Новый сообщение
        Text(
            text = "New",
            style = MaterialTheme.typography.headlineMedium,
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
        HorizontalDivider()

        /*
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            TextButton(onClick = { *//* TODO *//* }) { Text("Home") }
            TextButton(onClick = { *//* TODO *//* }) { Text("Devs") }
            TextButton(onClick = { *//* TODO *//* }) { Text("Apparatuses") }
            TextButton(onClick = { *//* TODO *//* }) { Text("Messages") }
            TextButton(onClick = { *//* TODO *//* }) { Text("Statistics") }
            TextButton(onClick = { *//* TODO *//* }) { Text("Settings") }
        }*/
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

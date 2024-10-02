package com.example.inspirationpoint.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MessageScreen(modifier: Modifier = Modifier, viewModelMessage: ViewModelMessage = hiltViewModel()) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp), // Общий отступ для экрана
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Messages",
            //style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(bottom = 16.dp)
        )

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
        MessageReceived()

        MessageSent()


        MessageNew()
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

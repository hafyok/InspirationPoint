package com.example.inspirationpoint

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MessageReceived(){
    Text(
        text = "Received",
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
            TableHeaderText(text = "Author")
            TableHeaderText(text = "Text")
        }
        HorizontalDivider()
        repeat(2) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TableRowText(text = "245")
                TableRowText(text = "13:56:20")
                TableRowText(text = "03.12.2022")
                TableRowText(text = "Dmitrii")
                TableRowText(text = "Approve all LiveData")
            }
            HorizontalDivider()
        }
    }
}
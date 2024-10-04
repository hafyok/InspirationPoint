package com.example.inspirationpoint.presentation.DevicesScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun DevicesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        var selectedTab by remember { mutableStateOf(0) }
        val tabs = listOf("All", "Live", "Approved", "Mute", "Blocked", "Dead")
        var selectedDevice by remember {
            mutableStateOf(Device("", "", "", "", ""))
        }

        Text(
            text = "Devices List",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        HorizontalDivider()

        LazyRow {
            itemsIndexed(tabs) { index, title ->
                FilterChip(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    onClick = { selectedTab = index },
                    label = {
                        Text(text = title)
                    },
                    selected = selectedTab == index,
                    leadingIcon = if (selectedTab == index) {
                        {
                            Icon(
                                imageVector = Icons.Filled.Done,
                                contentDescription = "Done icon",
                                modifier = Modifier.size(FilterChipDefaults.IconSize)
                            )
                        }
                    } else {
                        null
                    },
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Name")
            Text(text = "Type")
            Text(text = "Status")
            Text(text = "MAC")
            Text(text = "Subscription")
        }

        // Отфильтрованный список устройств
        val filteredDevices = filterDevicesByTab(devicesList, selectedTab)

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .height(250.dp)
        ) {
            items(filteredDevices) { device ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable { selectedDevice = device },
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = device.name)
                    Text(text = device.type)
                    Text(text = device.status)
                    Text(text = device.mac)
                    Text(text = device.subscription)
                }
                HorizontalDivider()
            }
        }

        Column(modifier = Modifier.padding(top = 16.dp)) {
            Text(text = selectedDevice.name, fontWeight = FontWeight.Bold)
            Text(text = "Type: ${selectedDevice.type}")
            Text(text = "Status: ${selectedDevice.status}")
            Text(text = "MAC: ${selectedDevice.mac}")
            Text(text = "Subscriptions: ${selectedDevice.subscription}")


        }
    }
}

// Функция для фильтрации списка устройств на основе выбранного таба
fun filterDevicesByTab(devices: List<Device>, selectedTab: Int): List<Device> {
    return when (selectedTab) {
        1 -> devices.filter { it.status == "live" }
        2 -> devices.filter { it.status == "approved" }
        3 -> devices.filter { it.status == "mute" }
        4 -> devices.filter { it.status == "blocked" }
        5 -> devices.filter { it.status == "dead" }
        else -> devices
    }
}

data class Device(
    val name: String,
    val type: String,
    val status: String,
    val mac: String,
    val subscription: String
)

val devicesList = listOf(
    Device("Cam-5", "Camera", "live", "fe:fe:f3:fe", "SM-03"),
    Device("Rep-1", "Camera", "dead", "fe:fe:f3:fe", "SM-03"),
    Device("LD-4", "LiveData", "mute", "fe:fe:f3:fe", "SM-03"),
    Device("Dmitrii", "Participant", "approved", "fe:fe:f3:fe", "no"),
    Device("Temp-7", "Sensor", "live", "ab:cd:ef:12", "SM-02"),
    Device("Light-12", "Light", "blocked", "ab:cd:ef:34", "SM-04"),
    Device("Sensor-2", "Sensor", "approved", "ab:cd:ef:56", "SM-05"),
    Device("Control-9", "Controller", "mute", "ab:cd:ef:78", "SM-06"),
    Device("Relay-3", "Relay", "live", "ab:cd:ef:90", "SM-07"),
    Device("Cam-6", "Camera", "dead", "ab:cd:ef:aa", "SM-08"),
    Device("LD-5", "LiveData", "approved", "ab:cd:ef:bb", "no"),
    Device("Mic-1", "Microphone", "live", "ab:cd:ef:cc", "SM-09"),
    Device("Rep-2", "Camera", "blocked", "ab:cd:ef:dd", "SM-10"),
    Device("Hub-1", "Hub", "mute", "ab:cd:ef:ee", "SM-11")
)
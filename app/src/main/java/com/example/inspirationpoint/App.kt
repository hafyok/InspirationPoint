package com.example.inspirationpoint

import android.app.Application
import com.example.inspirationpoint.data.AppDatabase
import com.example.inspirationpoint.data.MessageLocalSource
import com.example.inspirationpoint.data.MessageRepositoryImpl
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob


@HiltAndroidApp
class App: Application() {

}
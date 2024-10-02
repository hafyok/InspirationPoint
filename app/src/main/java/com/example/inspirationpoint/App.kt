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
    private val applicationScope = CoroutineScope(SupervisorJob())

    private val db by lazy { AppDatabase.getDatabase(this, /*applicationScope*/) }
    private val messageLocalSource by lazy { MessageLocalSource(db.daoMessage()) }
    val messageRepositoryImpl by lazy { MessageRepositoryImpl(messageLocalSource) }
}
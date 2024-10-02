package com.example.inspirationpoint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.inspirationpoint.data.AppDatabase
import com.example.inspirationpoint.presentation.ViewModelMessage
import com.example.inspirationpoint.ui.theme.InspirationPointTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var viewModelMessage: ViewModelMessage
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelMessage = ViewModelMessage((application as App).messageRepositoryImpl)
        enableEdgeToEdge()

        db = AppDatabase.getDatabase(this)
        setContent {
            InspirationPointTheme {

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    content = { innerPadding ->
                        AppNavigation(
                            modifier = Modifier
                                .padding(innerPadding) // Padding из Scaffold
                                .padding(WindowInsets.statusBars.asPaddingValues())
                        )
                    }
                )

            }
        }
    }
}

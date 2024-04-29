package com.example.tema1_android

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.ComposeView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.example.tema1_android.ui.theme.Tema1_AndroidTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCloseApp = findViewById<Button>(R.id.btnCloseApp)
        btnCloseApp.setOnClickListener {
            finish()
        }

        val composeView = findViewById<ComposeView>(R.id.compose_view)
        composeView.setContent {
            Tema1_AndroidTheme {
                MainContent()
            }
        }
    }

    @Composable
    fun MainContent() {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            ZooAnimalList(animals)
        }
    }
}


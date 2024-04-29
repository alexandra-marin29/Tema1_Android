package com.example.tema1_android

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tema1_android.ui.theme.Tema1_AndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Găsirea butonului în XML
        val btnCloseApp = findViewById<Button>(R.id.btnCloseApp)

        // Setarea unui click listener pentru buton
        btnCloseApp.setOnClickListener {
            finish()
        }
    }

}

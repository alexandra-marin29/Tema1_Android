package com.example.tema1_android

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.example.tema1_android.ui.theme.Tema1_AndroidTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCloseApp = findViewById<Button>(R.id.btnCloseApp)
        btnCloseApp.setOnClickListener {
            finish()
        }
        val backButton = findViewById<Button>(R.id.backButton)

        backButton.setOnClickListener {
            onBackPressed()
        }

        val composeView = findViewById<ComposeView>(R.id.compose_view)
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
        composeView.setContent {
            Tema1_AndroidTheme {
                MainContent()
            }
        }
    }

    @Composable
    fun MainContent() {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            AnimalList(animals) { animal ->
                openAnimalDetails(animal)
            }
        }
    }

    @Composable
    fun AnimalList(animals: List<Animal>, onAnimalClick: (Animal) -> Unit) {
        LazyColumn {
            items(animals) { animal ->
                AnimalRow(animal = animal, onClick = onAnimalClick)
            }
        }
    }

    fun openAnimalDetails(animal: Animal) {
        val fragment = AnimalDetailsFragment().apply {
            arguments = Bundle().apply {
                putString("name", animal.name)
                putString("continent", animal.continent)
            }
        }
        findViewById<FrameLayout>(R.id.container).visibility = View.VISIBLE
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }

}
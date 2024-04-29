package com.example.tema1_android

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

data class Animal(val name: String, val continent: String)

@Composable
fun ZooAnimalList(animals: List<Animal>) {
    LazyColumn {
        items(animals) { animal ->
            AnimalRow(animal)
        }
    }
}

@Composable
fun AnimalRow(animal: Animal) {
    val backgroundColor = when (animal.continent) {
        "Europe" -> Color.Green
        "Africa" -> Color.Yellow
        "Asia" -> Color.Red
        "North America" -> Color(0xFF8B4513) // Brown
        "South America" -> Color(0xFFFFA500) // Orange
        "Australia" -> Color.Magenta
        "Antarctica" -> Color.Blue
        else -> Color.Gray
    }
    val textAlign = when (animal.continent) {
        "Europe", "Africa" -> TextAlign.Left
        "North America", "South America" -> TextAlign.Right
        "Australia", "Antarctica" -> TextAlign.Center
        else -> TextAlign.Start
    }
    Box(
        modifier = Modifier.fillMaxWidth().background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Text("${animal.name} - ${animal.continent}", textAlign = textAlign, color = Color.Black)
    }
}

val animals = listOf(
    Animal("Lion", "Africa"),
    Animal("Tiger", "Asia"),
)

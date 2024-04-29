package com.example.tema1_android

import android.content.res.Resources
import android.graphics.drawable.GradientDrawable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.TextStyle
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


data class Animal(val name: String, val continent: String)

@Composable
fun AnimalRow(animal: Animal) {
    val backgroundColor = getContinentColor(animal.continent)
    val textColor = Color.Black
    val padding = 16.dp

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .background(backgroundColor)
    ) {
        when (animal.continent) {
            "Europe" -> {
                Column(modifier = Modifier.padding(padding)) {
                    Text(text = animal.name, color = textColor, fontSize = 16.sp)
                    Text(text = animal.continent, color = textColor, fontSize = 16.sp)
                }
            }
            "Africa" -> {
                Column(modifier = Modifier.padding(padding)) {
                    Text(text = animal.name, color = textColor, fontSize = 16.sp)
                    Divider(color = Color.Black, thickness = 1.dp)
                    Text(text = animal.continent, color = textColor, fontSize = 16.sp)
                }
            }
            "Asia" -> {
                Row(
                    modifier = Modifier
                        .padding(padding)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = animal.name, modifier = Modifier.weight(1f), color = textColor, fontSize = 16.sp)
                    Divider(color = Color.Black, modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp))
                    Text(text = animal.continent, modifier = Modifier.weight(1f), color = textColor, fontSize = 16.sp)
                }
            }
            "North America" -> {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(padding),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = animal.name,
                        color = textColor,
                        fontSize = 16.sp,
                        textAlign = TextAlign.End
                    )
                    Text(
                        text = animal.continent,
                        color = textColor,
                        fontSize = 16.sp,
                        textAlign = TextAlign.End
                    )
                }
            }
            "South America" -> {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(padding),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = animal.name,
                        color = textColor,
                        fontSize = 16.sp,
                        textAlign = TextAlign.End
                    )
                    Divider(color = Color.Black, thickness = 1.dp)
                    Text(
                        text = animal.continent,
                        color = textColor,
                        fontSize = 16.sp,
                        textAlign = TextAlign.End
                    )
                }
            }
            "Australia" -> {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(padding),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = animal.name, textAlign = TextAlign.Center, color = textColor, fontSize = 16.sp)
                    Text(text = animal.continent, textAlign = TextAlign.Center, color = textColor, fontSize = 16.sp)
                }
            }
            "Antarctica" -> {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(padding),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = animal.name, textAlign = TextAlign.Center, color = textColor, fontSize = 16.sp)
                    Divider(color = Color.Black, thickness = 1.dp)
                    Text(text = animal.continent, textAlign = TextAlign.Center, color = textColor, fontSize = 16.sp)
                }
            }
        }
    }
}

fun getContinentColor(continent: String): Color {
    return when (continent) {
        "Europe" -> Color.Green
        "Africa" -> Color.Yellow
        "Asia" -> Color.Red
        "North America" -> Color(0xFF8B4513) // Brown
        "South America" -> Color(0xFFFFA500) // Orange
        "Australia" -> Color.Magenta
        "Antarctica" -> Color.Blue
        else -> Color.Gray
    }
}

val animals = listOf(
    Animal("Eurasian Lynx", "Europe"),
    Animal("Brown Bear", "Europe"),
    Animal("Grey Wolf", "Europe"),
    Animal("European Roe Deer", "Europe"),
    Animal("Wild Boar", "Europe"),
    Animal("Scottish Wildcat", "Europe"),
    Animal("Alpine Ibex", "Europe"),
    Animal("Mongoose Lemur", "Europe"),
    Animal("Eurasian Sparrowhawk", "Europe"),
    Animal("Common Crane", "Europe"),


    Animal("Giant Panda", "Asia"),
    Animal("Red Panda", "Asia"),
    Animal("Siberian Tiger", "Asia"),
    Animal("Orangutan", "Asia"),
    Animal("Indian Rhinoceros", "Asia"),
    Animal("Komodo Dragon", "Asia"),
    Animal("Snow Leopard", "Asia"),
    Animal("Gharial", "Asia"),
    Animal("Golden Pheasant", "Asia"),
    Animal("Siamang", "Asia"),


    Animal("African Lion", "Africa"),
    Animal("African Elephant", "Africa"),
    Animal("Giraffe", "Africa"),
    Animal("Zebra", "Africa"),
    Animal("Black Rhinoceros", "Africa"),
    Animal("Cheetah", "Africa"),
    Animal("Hippopotamus", "Africa"),
    Animal("Meerkat", "Africa"),
    Animal("Secretarybird", "Africa"),
    Animal("African Grey Parrot", "Africa"),


    Animal("Emperor Penguin", "Antarctica"),
    Animal("Weddell Seal", "Antarctica"),
    Animal("Adélie Penguin", "Antarctica"),
    Animal("Chinstrap Penguin", "Antarctica"),
    Animal("Gentoo Penguin", "Antarctica"),
    Animal("Leopard Seal", "Antarctica"),
    Animal("Crabeater Seal", "Antarctica"),
    Animal("Wandering Albatross", "Antarctica"),
    Animal("Snow Petrel", "Antarctica"),
    Animal("Southern Rockhopper Penguin", "Antarctica"),


    Animal("Andean Condor", "South America"),
    Animal("Capybara", "South America"),
    Animal("Jaguar", "South America"),
    Animal("Giant Anteater", "South America"),
    Animal("Scarlet Macaw", "South America"),
    Animal("Spectacled Caiman", "South America"),
    Animal("Maned Wolf", "South America"),
    Animal("Green Anaconda", "South America"),
    Animal("Giant Armadillo", "South America"),


    Animal("American Bison", "North America"),
    Animal("Grizzly Bear", "North America"),
    Animal("Moose", "North America"),
    Animal("Polar Bear", "North America"),
    Animal("Rocky Mountain Bighorn Sheep", "North America"),
    Animal("Bald Eagle", "North America"),
    Animal("American Alligator", "North America"),
    Animal("Raccoon", "North America"),
    Animal("Gray Wolf", "North America"),
    Animal("Howler Monkey", "North America"),

    Animal("Kangaroo", "Australia"),
    Animal("Koala", "Australia"),
    Animal("Echidna", "Australia"),
    Animal("Wombat", "Australia"),
    Animal("Tasmanian Devil", "Australia"),
    Animal("Dingo", "Australia"),
    Animal("Emu", "Australia"),
    Animal("Cassowary", "Australia"),
    Animal("Kookaburra", "Australia"),
    Animal("Spangled Drongo", "Australia"),
    )

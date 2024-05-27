package com.example.tema1_android

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.unit.sp


data class Animal(val name: String, var continent: String)

@Composable
fun AnimalRow(animal: Animal, onClick: (Animal) -> Unit) {
    val backgroundColor = getContinentColor(animal.continent)
    val textColor = if (animal.continent in listOf("Europe", "Asia", "North America", "Australia", "Antarctica")) {
        Color.White
    } else {
        Color.Black
    }
    val padding = 16.dp
    val cellHeight = 108.dp

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(cellHeight)
            .padding(vertical = 8.dp)
            .background(
                shape = RoundedCornerShape(20.dp),
                color = backgroundColor
            )
            .clickable { onClick(animal) }

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
                    Divider(color = Color.Black, thickness = 1.5.dp)
                    Text(text = animal.continent, color = textColor, fontSize = 16.sp)
                }
            }
            "Asia" -> {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = animal.name,
                        color = textColor,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .weight(1f)
                            .wrapContentWidth(Alignment.CenterHorizontally)
                    )
                    Divider(
                        color = Color.Black,
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(1.5.dp)
                    )
                    Text(
                        text = animal.continent,
                        color = textColor,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .weight(1f)
                            .wrapContentWidth(Alignment.CenterHorizontally)
                    )
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
                    Divider(color = Color.Black, thickness = 1.5.dp)
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
                    Divider(color = Color.Black, thickness = 1.5.dp)
                    Text(text = animal.continent, textAlign = TextAlign.Center, color = textColor, fontSize = 16.sp)
                }
            }
        }
    }
}

fun getContinentColor(continent: String): Color {
    return when (continent) {
        "Europe" -> Color(0xFF008000)
        "Africa" -> Color(0xFFFFFF00)
        "Asia" -> Color(0xFFFF0000)
        "North America" -> Color(0xFFA52A2A)
        "South America" -> Color(0xFFFFA500)
        "Australia" -> Color(0xFF00008B)
        "Antarctica" -> Color(0xFF00719B)
        else -> Color.Gray
    }
}


val animals = listOf(
    Animal("African Lion", "Africa"),
    Animal("Chinchilla", "South America"),
    Animal("Giant Panda", "Asia"),
    Animal("American Bison", "North America"),
    Animal("Raccoon", "North America"),
    Animal("Grey Wolf", "Europe"),
    Animal("Eurasian Lynx", "Europe"),
    Animal("Komodo Dragon", "Asia"),
    Animal("Kangaroo", "Australia"),
    Animal("Maned Wolf", "South America"),
    Animal("Chinstrap Penguin", "Antarctica"),
    Animal("European Roe Deer", "Europe"),
    Animal("Wandering Albatross", "Antarctica"),
    Animal("Zebra", "Africa"),
    Animal("Scarlet Macaw", "South America"),
    Animal("Alpine Ibex", "Europe"),
    Animal("Brown Bear", "Europe"),
    Animal("Moose", "North America"),
    Animal("Bald Eagle", "North America"),
    Animal("Giant Armadillo", "South America"),
    Animal("Emperor Penguin", "Antarctica"),
    Animal("Koala", "Australia"),
    Animal("Black Rhinoceros", "Africa"),
    Animal("Green Anaconda", "South America"),
    Animal("Orangutan", "Asia"),
    Animal("Cheetah", "Africa"),
    Animal("Capybara", "South America"),
    Animal("Echidna", "Australia"),
    Animal("Wild Boar", "Europe"),
    Animal("Jaguar", "South America"),
    Animal("Giant Anteater", "South America"),
    Animal("American Alligator", "North America"),
    Animal("Scottish Wildcat", "Europe"),
    Animal("Indian Rhinoceros", "Asia"),
    Animal("Red Panda", "Asia"),
    Animal("African Elephant", "Africa"),
    Animal("Gentoo Penguin", "Antarctica"),
    Animal("Emu", "Australia"),
    Animal("Dingo", "Australia"),
    Animal("Tasmanian Devil", "Australia"),
    Animal("Rocky Mountain Bighorn Sheep", "North America"),
    Animal("Snow Petrel", "Antarctica"),
    Animal("Leopard Seal", "Antarctica"),
    Animal("Wombat", "Australia"),
    Animal("Grizzly Bear", "North America"),
    Animal("Giraffe", "Africa"),
    Animal("Andean Condor", "South America"),
    Animal("Red Panda", "Asia"),
    Animal("American Alligator", "North America"),
    Animal("Giraffe", "Africa")
    )

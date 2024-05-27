package com.example.tema1_android

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), AnimalAdapter.OnItemClickListener {

    private lateinit var nameOfAnAnimal: EditText
    private lateinit var continent: EditText
    private lateinit var addButton: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var animalAdapter: AnimalAdapter
    private val animals = mutableListOf<Animal>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameOfAnAnimal = findViewById(R.id.nameOfAnAnimal)
        continent = findViewById(R.id.continent)
        addButton = findViewById(R.id.addButton)
        recyclerView = findViewById(R.id.listOfAnimals)

        animalAdapter = AnimalAdapter(animals, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = animalAdapter

        addButton.setOnClickListener {
            addAnimal()
        }
    }

    private fun addAnimal() {
        val name = nameOfAnAnimal.text.toString().trim()
        val continentName = continent.text.toString().trim()

        if (name.isEmpty() || continentName.isEmpty()) {
            Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show()
            return
        }

        if (!isValidContinent(continentName)) {
            Toast.makeText(this, "Invalid continent", Toast.LENGTH_SHORT).show()
            return
        }

        val existingAnimal = animals.find { it.name.equals(name, ignoreCase = true) }
        if (existingAnimal != null) {
            existingAnimal.continent = continentName
        } else {
            animals.add(Animal(name, continentName))
        }

        animalAdapter.notifyDataSetChanged()
    }

    private fun isValidContinent(continent: String): Boolean {
        val validContinents = listOf("Africa", "Antarctica", "Asia", "Australia", "Europe", "North America", "South America")
        return continent in validContinents
    }

    override fun onItemClick(animal: Animal) {
        // Handle item click
    }

    override fun onItemDelete(animal: Animal) {
        animals.remove(animal)
        animalAdapter.notifyDataSetChanged()
    }
}

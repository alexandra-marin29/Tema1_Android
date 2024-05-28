package com.example.tema1_android

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tema1_android.database.Animal
import com.example.tema1_android.viewmodel.AnimalViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var nameOfAnAnimal: EditText
    private lateinit var continent: EditText
    private lateinit var addButton: Button
    private lateinit var recyclerView: RecyclerView
    private val animalViewModel: AnimalViewModel by viewModels()
    private lateinit var animalAdapter: AnimalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameOfAnAnimal = findViewById(R.id.nameOfAnAnimal)
        continent = findViewById(R.id.continent)
        addButton = findViewById(R.id.addButton)
        recyclerView = findViewById(R.id.listOfAnimals)

        animalAdapter = AnimalAdapter(emptyList(), object : AnimalAdapter.OnItemClickListener {
            override fun onItemClick(animal: Animal) {
                // Handle item click
            }

            override fun onItemDelete(animal: Animal) {
                animalViewModel.deleteAnimal(animal)
            }
        })

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = animalAdapter

        addButton.setOnClickListener {
            val name = nameOfAnAnimal.text.toString().trim()
            val continentName = continent.text.toString().trim()

            if (name.isEmpty() || continentName.isEmpty()) {
                Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!animalViewModel.isValidContinent(continentName)) {
                Toast.makeText(this, "Invalid continent", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            animalViewModel.addAnimal(name, continentName)
        }

        animalViewModel.allAnimals.observe(this, Observer { animals ->
            animals?.let { animalAdapter.updateData(it) }
        })
    }
}

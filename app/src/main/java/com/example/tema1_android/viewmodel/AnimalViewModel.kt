package com.example.tema1_android.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.tema1_android.database.Animal
import com.example.tema1_android.database.AnimalRepository
import kotlinx.coroutines.launch

class AnimalViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: AnimalRepository = AnimalRepository(application)
    val allAnimals: LiveData<List<Animal>> = repository.allAnimals

    fun addOrUpdateAnimal(name: String, continent: String) {
        viewModelScope.launch {
            repository.insertOrUpdateAnimal(name, continent)
        }
    }


    fun deleteAnimal(animal: Animal) {
        viewModelScope.launch {
            repository.deleteAnimal(animal)
        }
    }

    fun isValidContinent(continent: String): Boolean {
        val validContinents = listOf("Africa", "Antarctica", "Asia", "Australia", "Europe", "North America", "South America")
        return continent in validContinents
    }
}

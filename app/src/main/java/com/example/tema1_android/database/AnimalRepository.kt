package com.example.tema1_android.database

import android.app.Application
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AnimalRepository(application: Application) {
    private val animalDao: AnimalDao
    val allAnimals: LiveData<List<Animal>>

    init {
        val database = AppDatabase.getDatabase(application)
        animalDao = database.animalDao()
        allAnimals = animalDao.getAllAnimals()
    }

    suspend fun insertAnimal(name: String, continent: String) {
        withContext(Dispatchers.IO) {
            val existingAnimal = animalDao.getAnimalByName(name)
            if (existingAnimal != null) {
                existingAnimal.continent = continent
                animalDao.updateAnimal(existingAnimal)
            } else {
                animalDao.insertAnimal(Animal(name = name, continent = continent))
            }
        }
    }

    suspend fun deleteAnimal(animal: Animal) {
        withContext(Dispatchers.IO) {
            animalDao.deleteAnimalById(animal.id)
        }
    }
}

package com.example.tema1_android.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface AnimalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnimal(animal: Animal)

    @Update
    suspend fun updateAnimal(animal: Animal)

    @Query("SELECT * FROM animals WHERE LOWER(name) = LOWER(:name) LIMIT 1")
    suspend fun getAnimalByName(name: String): Animal?

    @Query("SELECT * FROM animals")
    fun getAllAnimals(): LiveData<List<Animal>>

    @Query("DELETE FROM animals WHERE id = :animalId")
    suspend fun deleteAnimalById(animalId: Int)
}

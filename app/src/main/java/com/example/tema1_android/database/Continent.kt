package com.example.tema1_android.database
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "continents")
data class Continent(
    @PrimaryKey val name: String
)

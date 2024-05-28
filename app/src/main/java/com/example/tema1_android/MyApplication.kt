package com.example.tema1_android

import android.app.Application
import androidx.room.Room
import com.example.tema1_android.database.AppDatabase

class MyApplication : Application() {
    lateinit var database: AppDatabase
        private set

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "zoo_database"
        ).build()
    }
}

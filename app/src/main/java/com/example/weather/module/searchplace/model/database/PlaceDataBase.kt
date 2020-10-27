package com.example.weather.module.searchplace.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.weather.model.LocationTypeConverter
import com.example.weather.model.Place
import com.example.weather.module.searchplace.dao.PlaceDao

/**
 * @author: klaus
 * @date: 2020/10/24
 */
@Database(entities = [Place::class], version = 1, exportSchema = false)
@TypeConverters(LocationTypeConverter::class)
abstract class PlaceDataBase : RoomDatabase() {
    abstract fun placeDao(): PlaceDao
    companion object {
        private var INSTANCE: PlaceDataBase? = null
        fun getInstance(context: Context): PlaceDataBase? {
            if (INSTANCE == null) {
                synchronized(PlaceDataBase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                                context,
                                PlaceDataBase::class.java,
                                "database_weather"
                        ).build()
                    }
                }
            }
            return INSTANCE
        }
    }
}
package com.example.weather.module.searchplace.dao

import androidx.room.*
import com.example.weather.model.Place

/**
 * Created with Android Studio.
 * Description:
 * @author: Wangjianxian
 * @CreateDate: 2020/6/8 23:11
 */
@Dao
interface PlaceDao {
    @Transaction
    @Insert(entity = Place::class)
    suspend fun insertPlace(place: Place) : Long

    @Transaction
    @Query("SELECT * FROM place ORDER BY primaryKey desc")
    suspend fun queryAllPlace() : MutableList<Place>

    @Transaction
    @Query("SELECT * FROM place WHERE name = (:name)")
    suspend fun queryPlaceByName(name : String) : Place?

    @Transaction
    @Query("SELECT * FROM place order by primaryKey desc")
    suspend fun queryFirstPlace() : Place?

    @Transaction
    @Delete(entity = Place::class)
    suspend fun deletePlace(place: Place) : Int

    @Transaction
    @Query("DELETE FROM place")
    suspend fun deleteAll()
}
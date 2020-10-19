package com.example.weather.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * @author: klaus
 * @date: 2020/10/15
 */
@Entity
data class Place(
    @PrimaryKey(autoGenerate = true)
    var primaryKey : Int,
    var name: String,
    val location: Location,
            @SerializedName("formatted_address") val address: String=""
) {
    constructor() : this(0, "", Location("", ""), "")
}
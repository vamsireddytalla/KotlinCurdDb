package com.talla.kotlinroomdb.entities

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Director(
    @NonNull
    @PrimaryKey(autoGenerate = false)
    val directorName:String,
    val schoolName:String)

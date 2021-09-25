package com.talla.kotlinroomdb.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.talla.kotlinroomdb.entities.Director
import com.talla.kotlinroomdb.entities.School

data class SchoolAndDirector(
    @Embedded
    val school: School,
    @Relation(parentColumn = "schoolName", entityColumn = "schoolName")
    val director: Director
    )

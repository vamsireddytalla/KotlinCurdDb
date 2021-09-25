package com.talla.kotlinroomdb.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.talla.kotlinroomdb.entities.School
import com.talla.kotlinroomdb.entities.Student

data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students:List<Student>
)

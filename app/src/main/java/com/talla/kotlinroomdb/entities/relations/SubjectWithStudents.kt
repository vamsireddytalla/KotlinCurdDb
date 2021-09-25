package com.talla.kotlinroomdb.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.talla.kotlinroomdb.entities.Student
import com.talla.kotlinroomdb.entities.Subject

data class SubjectWithStudents(
    @Embedded
    val subject: Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val students:List<Student>
)


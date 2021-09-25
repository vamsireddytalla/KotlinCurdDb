package com.talla.kotlinroomdb.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.talla.kotlinroomdb.entities.Student
import com.talla.kotlinroomdb.entities.Subject

data class StudentWithSubjects(
    @Embedded
    val student: Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects:List<Subject>
)

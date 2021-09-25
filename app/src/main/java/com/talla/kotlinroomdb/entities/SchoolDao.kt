package com.talla.kotlinroomdb.entities

import androidx.room.*
import com.talla.kotlinroomdb.entities.relations.*

@Dao
interface SchoolDao
{

    @Insert(onConflict=OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict=OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(studentSubjectCrossRef: StudentSubjectCrossRef)

    @Transaction
    @Query("SELECT * FROM School WHERE schoolName = :schoolName")
    suspend fun getSchoolANdDirector(schoolName: String):List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM School where schoolName=:schoolName")
    suspend fun getStudentWithSchool(schoolName:String):List<SchoolWithStudents>

    @Transaction
    @Query("SELECT * FROM Subject where subjectName=:subjectName")
    suspend fun getStudentsOfSubject(subjectName:String):List<SubjectWithStudents>

    @Transaction
    @Query("SELECT * FROM Student where studentName=:studentName")
    suspend fun getSubjectsOfStudent(studentName:String):List<StudentWithSubjects>

}
package com.talla.kotlinroomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.talla.kotlinroomdb.databinding.ActivityMainBinding
import com.talla.kotlinroomdb.entities.*
import com.talla.kotlinroomdb.entities.relations.StudentSubjectCrossRef
import kotlinx.coroutines.launch
private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity()
{
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tv1.text="Vamsi"

        val databaseInstance=SchoolDatabase.getDataBase(this)
        val schoolDao=databaseInstance.schoolDao

        val directors = listOf(
            Director("Mike Litoris", "Jake Wharton School"),
            Director("Jack Goff", "Kotlin School"),
            Director("Chris P. Chicken", "JetBrains School")
        )
        val schools = listOf(
            School("Jake Wharton School"),
            School("Kotlin School"),
            School("JetBrains School")
        )
        val subjects = listOf(
            Subject("Dating for programmers"),
            Subject("Avoiding depression"),
            Subject("Bug Fix Meditation"),
            Subject("Logcat for Newbies"),
            Subject("How to use Google")
        )
        val students = listOf(
            Student("Beff Jezos", 2, "Kotlin School"),
            Student("Mark Suckerberg", 5, "Jake Wharton School"),
            Student("Gill Bates", 8, "Kotlin School"),
            Student("Donny Jepp", 1, "Kotlin School"),
            Student("Hom Tanks", 2, "JetBrains School")
        )
        val studentSubjectRelations = listOf(
            StudentSubjectCrossRef("Beff Jezos", "Dating for programmers"),
            StudentSubjectCrossRef("Beff Jezos", "Avoiding depression"),
            StudentSubjectCrossRef("Beff Jezos", "Bug Fix Meditation"),
            StudentSubjectCrossRef("Beff Jezos", "Logcat for Newbies"),
            StudentSubjectCrossRef("Mark Suckerberg", "Dating for programmers"),
            StudentSubjectCrossRef("Gill Bates", "How to use Google"),
            StudentSubjectCrossRef("Donny Jepp", "Logcat for Newbies"),
            StudentSubjectCrossRef("Hom Tanks", "Avoiding depression"),
            StudentSubjectCrossRef("Hom Tanks", "Dating for programmers")
        )


        lifecycleScope.launch {
            directors.forEach { schoolDao.insertDirector(it) }
            schools.forEach { schoolDao.insertSchool(it) }
            subjects.forEach { schoolDao.insertSubject(it) }
            students.forEach { schoolDao.insertStudent(it) }
            studentSubjectRelations.forEach { schoolDao.insertStudentSubjectCrossRef(it) }

            val schoolWithDirector = schoolDao.getSchoolANdDirector("Kotlin School")

            val schoolWithStudents = schoolDao.getStudentWithSchool("Kotlin School")

            Log.d(TAG, "Data 1 $schoolWithDirector")
            Log.d(TAG, "Data 2 $schoolWithStudents")

        }


    }
}
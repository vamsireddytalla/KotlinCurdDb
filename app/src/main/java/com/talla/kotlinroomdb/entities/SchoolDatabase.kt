package com.talla.kotlinroomdb.entities

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.talla.kotlinroomdb.entities.relations.StudentSubjectCrossRef

@Database(
    entities = [School::class,
        Director::class,
        Subject::class,
        Student::class,
        StudentSubjectCrossRef::class], version = 1
)
abstract class SchoolDatabase : RoomDatabase() {

    abstract val schoolDao: SchoolDao


    companion object {
        //here volatile means it tells to other threads immediately we changed instance value
        @Volatile
        private var INSTANCE: SchoolDatabase? = null

        fun getDataBase(context:Context):SchoolDatabase{
            //syncronised means it only execute by only single thread
            synchronized(this)
            {
                return INSTANCE?: Room.databaseBuilder(context.applicationContext,SchoolDatabase::class.java,"SchoolDb").build().also {
                    INSTANCE=it
                }
            }
        }

    }


}
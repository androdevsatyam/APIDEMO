package com.satyam.apidemo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by SATYAM on 20/03/23.
 * Associated with IOVRVF
 * Contact me on: satyamiovrvf@gmail.com
 */
@Database(entities = [UserData::class], version = 1)
abstract class MyDatabase : RoomDatabase() {

    abstract fun userDataDao(): UserDataDao

    companion object {

        @Volatile
        private var INSTANCE: MyDatabase? = null

        fun getDatabases(context: Context): MyDatabase {
            val instace = INSTANCE
            if (instace != null) {
                return instace
            }
            synchronized(this) {
                val instace = Room.databaseBuilder(
                    context,
                    MyDatabase::class.java,
                    "UserDatabase"
                ).build()
                INSTANCE = instace
                return instace
            }
        }
    }
}
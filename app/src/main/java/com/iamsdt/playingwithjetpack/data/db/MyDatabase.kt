/*
 * Developed By Shudipto Trafder
 * at 9/1/18 5:49 PM
 * Copyright (c) 9/1/18 5:49 PM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.iamsdt.playingwithjetpack.data.retrofit.PojoKt


@Database(entities = [(PojoKt::class)],version = 1,
        //don't export database
        exportSchema = false)
abstract class MyDatabase: RoomDatabase(){


    abstract val retDao: RetDao

    companion object {

        private var instance: MyDatabase?= null
        private val dbName = "Pojokt"

        fun getDatabase(context: Context): MyDatabase {

            if (instance == null) {
                instance = Room.databaseBuilder(context,
                        MyDatabase::class.java, dbName).build()
            }

            return instance!!
        }
    }

}
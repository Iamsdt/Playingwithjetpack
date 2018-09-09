/*
 * Developed By Shudipto Trafder
 * at 9/1/18 5:49 PM
 * Copyright (c) 9/1/18 5:49 PM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.base.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.iamsdt.playingwithjetpack.base.data.retrofit.pojo.Photos
import com.iamsdt.playingwithjetpack.base.data.retrofit.pojo.Posts


@Database(entities = [Photos::class,
    Posts::class], version = 1,
        //don't export database
        exportSchema = false)
abstract class MyDatabase : RoomDatabase() {


    abstract val retDao: RetDao

    abstract val postDao:PostDao

    companion object {

        private var instance: MyDatabase? = null
        private val dbName = "Pojokt"


        //inject by koin
        fun getDatabase(context: Context): MyDatabase {

            if (instance == null) {
                instance = Room.databaseBuilder(context,
                        MyDatabase::class.java, dbName).build()
            }

            return instance!!
        }
    }

}
/*
 * Developed By Shudipto Trafder
 * at 9/9/18 10:34 PM
 * Copyright (c) 9/9/18 10:34 PM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.base.data.db

import androidx.paging.DataSource
import androidx.room.*
import com.iamsdt.playingwithjetpack.base.data.retrofit.pojo.Posts

@Dao
interface PostDao {

    @Query("Select * From Posts")
    fun getData(): DataSource.Factory<Int, Posts>

    @Query("Select * From Posts")
    fun getList(): List<Posts>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg photos: Posts): Long

    @Delete
    fun delete(photos: Posts): Int

    @Update
    fun update(photos: Posts): Int
}
/*
 * Developed By Shudipto Trafder
 * at 9/1/18 5:49 PM
 * Copyright (c) 9/1/18 5:49 PM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.base.data.db

import androidx.paging.DataSource
import androidx.room.*
import com.iamsdt.playingwithjetpack.base.data.retrofit.pojo.Photos


@Dao
interface RetDao {

    @Query("Select * From Photos")
    fun getData(): DataSource.Factory<Int, Photos>

    @Query("Select * From Photos")
    fun getList():List<Photos>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(photos: Photos): Long

    @Delete
    fun delete(photos: Photos): Int

    @Update
    fun update(photos: Photos): Int
}
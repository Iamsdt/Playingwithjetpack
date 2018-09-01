/*
 * Developed By Shudipto Trafder
 * at 9/1/18 5:49 PM
 * Copyright (c) 9/1/18 5:49 PM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.data.db

import androidx.paging.DataSource
import androidx.room.*
import com.iamsdt.playingwithjetpack.data.retrofit.PojoKt


@Dao
interface RetDao {

    @Query("Select * From PojoKt")
    fun getData(): DataSource.Factory<Int, PojoKt>

    @Query("Select * From PojoKt")
    fun getList():List<PojoKt>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pojoKt: PojoKt): Long

    @Delete
    fun delete(pojoKt: PojoKt): Int

    @Update
    fun update(pojoKt: PojoKt): Int
}
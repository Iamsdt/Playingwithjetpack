/*
 * Developed By Shudipto Trafder
 * at 9/7/18 11:24 PM
 * Copyright (c) 9/7/18 11:24 PM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.base.data.retrofit.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity
data class Photos(
        @SerializedName("albumId")
        val albumId: Int = 0,
        @SerializedName("id")
        @PrimaryKey(autoGenerate = false)
        val id: Int = 0,
        @SerializedName("title")
        val title: String = "",
        @SerializedName("url")
        val url: String = "",
        @SerializedName("thumbnailUrl")
        val thumbnailUrl: String = "")
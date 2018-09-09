/*
 * Developed By Shudipto Trafder
 * at 9/7/18 11:19 PM
 * Copyright (c) 9/7/18 11:19 PM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.base.data.retrofit.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Posts(
        @SerializedName("id")
        @PrimaryKey
        val id: Int = 0,
        @SerializedName("title")
        val title: String = "",
        @SerializedName("body")
        val body: String = "",
        @SerializedName("userId")
        val userId: Int = 0)
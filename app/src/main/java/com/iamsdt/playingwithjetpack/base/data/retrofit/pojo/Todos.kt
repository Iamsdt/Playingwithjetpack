/*
 * Developed By Shudipto Trafder
 * at 9/7/18 11:23 PM
 * Copyright (c) 9/7/18 11:23 PM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.base.data.retrofit.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Todos(@SerializedName("id")
                 @PrimaryKey
                 val id: Int = 0,
                 @SerializedName("completed")
                 val completed: Boolean = false,
                 @SerializedName("title")
                 val title: String = "",
                 @SerializedName("userId")
                 val userId: Int = 0)
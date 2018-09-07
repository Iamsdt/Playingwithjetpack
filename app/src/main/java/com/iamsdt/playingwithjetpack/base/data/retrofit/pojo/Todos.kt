/*
 * Developed By Shudipto Trafder
 * at 9/7/18 11:23 PM
 * Copyright (c) 9/7/18 11:23 PM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.base.data.retrofit.pojo

import com.google.gson.annotations.SerializedName

data class Todos(@SerializedName("id")
                 val id: Int = 0,
                 @SerializedName("completed")
                 val completed: Boolean = false,
                 @SerializedName("title")
                 val title: String = "",
                 @SerializedName("userId")
                 val userId: Int = 0)
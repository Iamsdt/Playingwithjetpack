/*
 * Developed By Shudipto Trafder
 * at 9/7/18 11:20 PM
 * Copyright (c) 9/7/18 11:20 PM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.base.data.retrofit.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Comments(@SerializedName("name")
                    val name: String = "",
                    @SerializedName("postId")
                    val postId: Int = 0,
                    @SerializedName("id")
                    @PrimaryKey
                    val id: Int = 0,
                    @SerializedName("body")
                    val body: String = "",
                    @SerializedName("email")
                    val email: String = "")
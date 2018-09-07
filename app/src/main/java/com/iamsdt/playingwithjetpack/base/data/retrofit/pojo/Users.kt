/*
 * Developed By Shudipto Trafder
 * at 9/7/18 11:25 PM
 * Copyright (c) 9/7/18 11:25 PM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.base.data.retrofit.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Users(
        @PrimaryKey(autoGenerate = false)
        val id: Int = 0,
        val website: String = "",
        val phone: String = "",
        val name: String = "",
        val email: String = "",
        val username: String = "",
        val zipcode: String = "",
        val suite: String = "",
        val city: String = "",
        val street: String = "",
        val bs: String = "",
        val catchPhrase: String = "",
        val companyName: String = "",
        val lng: String = "",
        val lat: String = "")
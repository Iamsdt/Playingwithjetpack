/*
 * Developed By Shudipto Trafder
 * at 9/1/18 5:47 PM
 * Copyright (c) 9/1/18 5:47 PM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.data.retrofit

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class PojoKt(var albumId: Int = 0,
                  @PrimaryKey(autoGenerate = false)
                  var id: Int = 0,
                  var title: String = "",
                  var url: String = "",
                  var thumbnailUrl: String = "")
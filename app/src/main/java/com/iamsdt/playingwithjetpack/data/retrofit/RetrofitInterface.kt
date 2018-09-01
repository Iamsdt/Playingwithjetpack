/*
 * Developed By Shudipto Trafder
 * at 9/1/18 5:48 PM
 * Copyright (c) 9/1/18 5:48 PM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.data.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface{

    @GET("photos/")
    fun getData(): Call<List<PojoKt>>
}
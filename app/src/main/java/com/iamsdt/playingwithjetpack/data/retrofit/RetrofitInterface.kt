/*
 * Developed By Shudipto Trafder
 * at 9/1/18 5:48 PM
 * Copyright (c) 9/1/18 5:48 PM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.data.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface{

    @GET("comments/")
    fun getComments(): Call<List<PojoKt>>

    @GET("photos/")
    fun getImage(): Call<List<PojoKt>>

    @GET("photos/")
    fun getPost(): Call<List<PojoKt>>

    @GET("photos/")
    fun getUser(): Call<List<PojoKt>>

    @GET("todos/")
    fun getTodo(): Call<List<PojoKt>>

    @GET("albums/")
    fun getAlbums(): Call<List<PojoKt>>
}
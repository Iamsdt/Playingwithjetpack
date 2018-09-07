/*
 * Developed By Shudipto Trafder
 * at 9/1/18 5:48 PM
 * Copyright (c) 9/1/18 5:48 PM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.base.data.retrofit

import com.iamsdt.playingwithjetpack.base.data.retrofit.pojo.*
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface{

    @GET("comments/")
    fun getComments(): Call<List<Comments>>

    @GET("photos/")
    fun getImage(): Call<List<Photos>>

    @GET("posts/")
    fun getPost(): Call<List<Posts>>

    @GET("users/")
    fun getUser(): Call<List<Users>>

    @GET("todos/")
    fun getTodo(): Call<List<Todos>>

    @GET("albums/")
    fun getAlbums(): Call<List<Albums>>
}
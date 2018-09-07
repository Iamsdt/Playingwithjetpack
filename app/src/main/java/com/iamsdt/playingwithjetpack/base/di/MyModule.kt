/*
 * Developed By Shudipto Trafder
 * at 9/1/18 5:57 PM
 * Copyright (c) 9/1/18 5:57 PM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.base.di

import androidx.room.Room
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.iamsdt.playingwithjetpack.base.data.db.MyDatabase
import com.iamsdt.playingwithjetpack.base.data.retrofit.RetrofitInterface
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

val dbModule = module {

    //get dao
    single { get<MyDatabase>().retDao }

    //build database
    single {
        Room.databaseBuilder(androidContext(),
                MyDatabase::class.java,"DB")
                .build()
    }
}

val networkModule = module {


    //ret interface
    single {
        get<Retrofit>().create(RetrofitInterface::class.java)
    }

    //retrofit
    single {
        Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(
                        GsonConverterFactory.create(get() as Gson))
                .client(get() as OkHttpClient)
                .build()
    }

    //gson
    single {
        GsonBuilder().create()
    }


    //picasso
    single {
        Picasso.Builder(androidContext())
                .downloader(OkHttp3Downloader(get() as OkHttpClient))
                .loggingEnabled(true)
                .build()
    }


    //ok http
    single {
        OkHttpClient.Builder()
                .cache(get() as Cache)
                .addInterceptor(get() as HttpLoggingInterceptor)
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES).build()
    }


    //logging interceptor
    single {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
    }


    //set cache
    single {
        Cache(get() as File, 10 * 1024 * 1024)
    }

    //create file
    single {
        File(androidContext().cacheDir, "okHttp")
    }


}

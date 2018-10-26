/*
 * Developed By Shudipto Trafder
 * at 9/1/18 6:25 PM
 * Copyright (c) 9/1/18 6:25 PM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.work.work

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.iamsdt.playingwithjetpack.base.data.db.RetDao
import com.iamsdt.playingwithjetpack.base.data.retrofit.RetrofitInterface
import com.iamsdt.playingwithjetpack.base.data.retrofit.pojo.Photos
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class DataInsertWork(context: Context, params: WorkerParameters) :
        Worker(context, params), KoinComponent {

    private val retrofitInterface: RetrofitInterface by inject()

    private val dao: RetDao by inject()

    override fun doWork(): Result {

        Timber.i("Start Working")

        var result = Result.FAILURE

        retrofitInterface.getImage().enqueue(object : Callback<List<Photos>> {

            override fun onFailure(call: Call<List<Photos>>?, t: Throwable?) {
                Timber.e(t, "data is not coming from server")

                //return with retry request
                result = Result.RETRY
                Timber.i("Result.RETRY")
            }

            //response
            override fun onResponse(call: Call<List<Photos>>?, response: Response<List<Photos>>?) {

                response?.let { it ->
                    if (it.isSuccessful) {
                        it.body()?.let { list ->
                            if (list.isNotEmpty()) {

                                var insert = 0L
                                list.forEach {
                                    insert = dao.insert(it)
                                }

                                if (insert > 0) {
                                    Timber.i("Data inserted")
                                    result = Result.SUCCESS
                                    Timber.i("Result.SUCCESS")
                                }
                            } else {
                                result = Result.RETRY
                                Timber.i("Result.RETRY")
                            }
                        }

                    } else {
                        result = Result.RETRY
                        Timber.i("Result.RETRY")
                    }
                }

            }

        })

        Timber.i("Return from Worker class")
        return result
    }

}
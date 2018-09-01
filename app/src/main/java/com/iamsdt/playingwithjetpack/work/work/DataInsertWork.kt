/*
 * Developed By Shudipto Trafder
 * at 9/1/18 6:25 PM
 * Copyright (c) 9/1/18 6:25 PM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.work.work

import androidx.work.Worker
import com.iamsdt.playingwithjetpack.data.db.RetDao
import com.iamsdt.playingwithjetpack.data.retrofit.PojoKt
import com.iamsdt.playingwithjetpack.data.retrofit.RetrofitInterface
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class DataInsertWork : Worker(), KoinComponent {

    private val retrofitInterface: RetrofitInterface by inject()

    private val dao: RetDao by inject()

    override fun doWork(): Result {

        Timber.i("Start Working")

        var result = Result.FAILURE

        retrofitInterface.getData().enqueue(object : Callback<List<PojoKt>> {

            override fun onFailure(call: Call<List<PojoKt>>?, t: Throwable?) {
                Timber.e(t, "data is not coming from server")

                //return with retry request
                result = Result.RETRY
                Timber.i("Result.RETRY")
            }

            //response
            override fun onResponse(call: Call<List<PojoKt>>?, response: Response<List<PojoKt>>?) {

                response?.let {
                    if (it.isSuccessful) {
                        it.body()?.let { list ->
                            if (list.isNotEmpty()) {

                                var insert = 0L
                                list.forEach {
                                    insert = dao.insert(it)
                                }

                                if (insert > 0){
                                    Timber.i("Data inserted")
                                    result = Result.SUCCESS
                                    Timber.i("Result.SUCCESS")
                                }
                            } else{
                                result = Result.RETRY
                                Timber.i("Result.RETRY")
                            }
                        }

                    } else{
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
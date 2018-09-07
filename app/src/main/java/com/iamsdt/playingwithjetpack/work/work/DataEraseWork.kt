/*
 * Developed By Shudipto Trafder
 * at 9/1/18 6:26 PM
 * Copyright (c) 9/1/18 6:26 PM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.work.work

import androidx.work.Worker
import com.iamsdt.playingwithjetpack.base.data.db.RetDao
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import timber.log.Timber

class DataEraseWork : Worker(), KoinComponent {

    private val dao: RetDao by inject()

    override fun doWork(): Result {

        Timber.i("Start Working")

        // no need to care about main and background thread
        // it will execute on background thread

        val data = dao.getList()

        if (data.isEmpty()) return Result.FAILURE

        var delete = 0
        data.forEach {
            delete = dao.delete(it)
        }


        if (delete > 0){
            Timber.i("Data delete complete")
            return Result.SUCCESS
        }



        Timber.i("Return from Worker class")
        return Result.FAILURE
    }

}
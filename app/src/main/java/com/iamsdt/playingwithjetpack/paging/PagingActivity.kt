/*
 * Developed By Shudipto Trafder
 * at 9/12/18 9:34 PM
 * Copyright (c) 9/12/18 9:34 PM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.paging

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.iamsdt.playingwithjetpack.R
import com.iamsdt.playingwithjetpack.base.data.db.RetDao
import com.iamsdt.playingwithjetpack.base.ext.ioThread
import com.iamsdt.playingwithjetpack.base.ext.toNextActivity
import com.iamsdt.playingwithjetpack.work.work.DataInsertWork
import kotlinx.android.synthetic.main.activity_paging.*
import org.koin.android.ext.android.inject

class PagingActivity : AppCompatActivity() {

    //instance of work manager
    private lateinit var manager: WorkManager

    //data accessing object
    private val retDao: RetDao by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paging)

        manager = WorkManager.getInstance()


        page_db.setOnClickListener {
            startDatabase()
        }


        //ensure all data present in db
        manager.getStatusesByTag("insert").observe(this, Observer { it ->
            if (it?.isNotEmpty() == true) {

                //just one task under this tag
                //so access [0] of the list
                if (it[0].state.isFinished) {
                    toNextActivity(PagingBasic::class)
                }

            }
        })
    }


    /*
        Start work to insert database
     */
    private fun startDatabase() {
        ioThread {

            val list = retDao.getList()

            if (list.isEmpty()) {
                startInsert()
            }
        }
    }

    // Start work command
    private fun startInsert() {
        //cons
        val myConstraints = Constraints.Builder()
                .setRequiresCharging(true)
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

        val insert = OneTimeWorkRequestBuilder<DataInsertWork>()
                .setConstraints(myConstraints)
                .addTag("insert")
                .build()

        manager.enqueue(insert)
    }
}

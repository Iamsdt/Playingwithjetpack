/*
 * Developed By Shudipto Trafder
 * at 9/1/18 5:23 PM
 * Copyright (c) 9/1/18 5:23 PM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.work

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.*
import com.iamsdt.playingwithjetpack.R
import com.iamsdt.playingwithjetpack.base.ext.ToastType
import com.iamsdt.playingwithjetpack.base.ext.addStr
import com.iamsdt.playingwithjetpack.base.ext.showToast
import com.iamsdt.playingwithjetpack.work.work.DataEraseWork
import com.iamsdt.playingwithjetpack.work.work.DataInsertWork
import kotlinx.android.synthetic.main.activity_work_manager_basic.*
import kotlinx.android.synthetic.main.content_work_manager_basic.*
import java.util.concurrent.TimeUnit

class WorkManagerBasicActivity : AppCompatActivity() {

    lateinit var manager: WorkManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager_basic)
        setSupportActionBar(toolbar)

        manager = WorkManager.getInstance()

        photo_start.setOnClickListener {
            startInsert()
        }

        photo_cancel.setOnClickListener {
            manager.cancelAllWorkByTag("insert")
        }

        delete_btn.setOnClickListener {
            deleteWork()
        }

        delete_btn_cancel.setOnClickListener {
            manager.cancelAllWorkByTag("delete")
        }

//        manager.getStatusesByTag("insert").observe(this, Observer { it ->
//            if (it.isNotEmpty() && it[0].tags.contains("insert")) {
//                val state = it[0].state
//                photo_tv.addStr(state.toString())
//
//                if (state.isFinished) {
//                    showToast(ToastType.SUCCESSFUL, "Complete")
//                }
//            }
//        })

//        manager.getStatusesByTag("delete").observe(this, Observer { it ->
//            if (it.isNotEmpty() && it[0].tags.contains("delete")) {
//                val state = it[0].state
//                photo_tv.addStr(state.toString())
//
//                if (state.isFinished) {
//                    showToast(ToastType.SUCCESSFUL, "Complete")
//                }
//            }
//        })


    }

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

    private fun deleteWork() {
        val myConstraints = Constraints.Builder()
                .setRequiresCharging(true)
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

        val delete = PeriodicWorkRequest.Builder(
                DataEraseWork::class.java, 15, TimeUnit.MINUTES)
                .setConstraints(myConstraints)
                .addTag("delete")
                .build()

        manager.enqueue(delete)
    }

}

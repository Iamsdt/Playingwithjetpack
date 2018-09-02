/*
 * Developed By Shudipto Trafder
 * at 9/1/18 5:23 PM
 * Copyright (c) 9/1/18 5:23 PM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.work

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.iamsdt.playingwithjetpack.R
import com.iamsdt.playingwithjetpack.work.work.DataInsertWork
import kotlinx.android.synthetic.main.activity_work_manager_basic.*

class WorkManagerBasicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager_basic)
        setSupportActionBar(toolbar)


        //cons
        val myConstraints = Constraints.Builder()
                .setRequiresCharging(true)
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            myConstraints.setRequiresDeviceIdle(true)
        }

        val work = OneTimeWorkRequestBuilder<DataInsertWork>()
                .addTag("MyWork")
                .build()

        WorkManager.getInstance().enqueue(work)

    }

}

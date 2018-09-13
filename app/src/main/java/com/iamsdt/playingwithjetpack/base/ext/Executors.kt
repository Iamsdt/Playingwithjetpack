/*
 * Developed By Shudipto Trafder
 * at 9/9/18 9:51 PM
 * Copyright (c) 9/9/18 9:51 PM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.base.ext

import android.os.AsyncTask
import android.os.Handler
import android.os.Looper


// run code in background
//take function as parameter
fun ioThread(f: () -> Unit) {
    AsyncTask.execute(f)
}

//run code in the ui thread
//take function as parameter
fun uiThread(f: () -> Unit) {
    Handler(Looper.getMainLooper()).post(f)
}
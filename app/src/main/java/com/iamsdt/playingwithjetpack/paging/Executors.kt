/*
 * Developed By Shudipto Trafder
 * at 9/9/18 9:51 PM
 * Copyright (c) 9/9/18 9:51 PM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.paging

import android.os.AsyncTask

fun ioThread(f: () -> Unit) {
    AsyncTask.execute(f)
}
/*
 * Developed By Shudipto Trafder
 * at 9/1/18 6:21 PM
 * Copyright (c) 9/1/18 6:21 PM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.base.ext

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

fun <T> LiveData<T>.blockingObserve(): T? {
    var value: T? = null
    val latch = CountDownLatch(1)
    val innerObserver = Observer<T> {
        value = it
        latch.countDown()
    }
    observeForever(innerObserver)
    latch.await(2, TimeUnit.SECONDS)
    return value
}
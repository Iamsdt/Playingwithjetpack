/*
 * Developed By Shudipto Trafder
 * at 9/1/18 12:18 AM
 * Copyright (c) 9/1/18 12:18 AM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.ext

fun CharSequence.toDouble(): Double {
    val sequence = this.toString()
    return sequence.toDoubleOrNull() ?: 0.0
}
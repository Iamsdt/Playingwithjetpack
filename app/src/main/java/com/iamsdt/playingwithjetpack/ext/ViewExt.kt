/*
 * Developed By Shudipto Trafder
 * at 9/1/18 6:21 PM
 * Copyright (c) 9/1/18 6:21 PM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.ext

import android.view.View
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

fun View.gone(){
    visibility = View.GONE
}

fun View.show(){
    visibility = View.VISIBLE
}

fun View.inVisible(){
    visibility = View.INVISIBLE
}

fun View.changeHeight(height: Int){
    requestLayout()
    layoutParams.height = height
}

fun TextView.addStr(string: String){
    this.text = string
}

fun View.showSnackbar(snackbarText: String, timeLength: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, snackbarText, timeLength).show()
}
/*
 * Developed By Shudipto Trafder
 * at 9/9/18 9:35 PM
 * Copyright (c) 9/9/18 9:35 PM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.paging.source

import androidx.paging.PositionalDataSource
import com.iamsdt.playingwithjetpack.base.data.retrofit.pojo.Photos

class PosDataSource:PositionalDataSource<Photos>(){

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Photos>) {

    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Photos>) {

    }

}
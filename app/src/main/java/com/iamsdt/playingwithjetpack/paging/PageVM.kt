/*
 * Developed By Shudipto Trafder
 * at 9/9/18 10:22 PM
 * Copyright (c) 9/9/18 10:22 PM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.paging

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.iamsdt.playingwithjetpack.base.data.db.RetDao
import com.iamsdt.playingwithjetpack.base.data.retrofit.pojo.Photos

class PageVM(private val retDao: RetDao) : ViewModel() {


    fun getData(): LiveData<PagedList<Photos>> {

        val source = retDao.getData()

        val config = PagedList.Config.Builder()
                .setPageSize(30)
                .setPrefetchDistance(30) //default same as page size
                .setInitialLoadSizeHint(50) //default 3 * page size
                .setEnablePlaceholders(false)//default true
                .build()


        return LivePagedListBuilder(source, config).build()
    }

    //delete on background thread
    fun remove(photos: Photos) = ioThread {
        retDao.delete(photos)
    }


}
/*
 * Developed By Shudipto Trafder
 * at 9/9/18 9:31 PM
 * Copyright (c) 9/9/18 9:31 PM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.paging

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iamsdt.playingwithjetpack.R
import kotlinx.android.synthetic.main.activity_paging_basic.*
import kotlinx.android.synthetic.main.content_paging_basic.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PagingBasic : AppCompatActivity() {

    val viewModel: PageVM by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paging_basic)
        setSupportActionBar(toolbar)

        val adapter = PAdapter()

        pagingList.layoutManager = LinearLayoutManager(this)
        pagingList.adapter = adapter

        initSwipeToDelete(pagingList)

        //pass the adapter
        //viewModel.getData().observe(this, Observer(adapter::submitList))

        viewModel.getData().observe(this, Observer {
            adapter.submitList(it)
        })

    }


    private fun initSwipeToDelete(view: RecyclerView) {
        ItemTouchHelper(object : ItemTouchHelper.Callback() {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                //access the current post
                (viewHolder as? PAdapter.PageVH)?.posts?.let {
                    //now remove this
                    viewModel.remove(it)
                }
            }

            // enable the items to swipe to the left or right
            override fun getMovementFlags(recyclerView: RecyclerView,
                                          viewHolder: RecyclerView.ViewHolder): Int =
                    makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder,
                                target: RecyclerView.ViewHolder): Boolean = false

            // When an item is swiped, remove the item via the view model. The list item will be
            // automatically removed in response, because the adapter is observing the live list.

        }).attachToRecyclerView(view)
    }


}

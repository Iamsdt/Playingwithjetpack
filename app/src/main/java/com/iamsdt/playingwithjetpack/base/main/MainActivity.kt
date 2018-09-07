package com.iamsdt.playingwithjetpack.base.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.iamsdt.playingwithjetpack.R
import com.iamsdt.playingwithjetpack.base.ext.toNextActivity
import com.iamsdt.playingwithjetpack.work.WorkManagerBasicActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), MainAdapter.Click {

    private val list: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        main_rcv.layoutManager = GridLayoutManager(this, 2)

        //fill the list
        fillList()

        // instance of adapter
        val adapter = MainAdapter(this)
        main_rcv.adapter = adapter

        adapter.submitList(list)

    }

    //add entry to list
    private fun fillList() {
        list.add("Work Manager")
        list.add("View Model")
        list.add("Fragment")
        list.add("Data Binding")
        list.add("Paging")
    }

    override fun click(position: Int) {
        val string = list[position]

        val next = when(string){
            list[0] -> WorkManagerBasicActivity::class
            else -> MainActivity::class
        }

        //go to next activity
        toNextActivity(next)
    }

}

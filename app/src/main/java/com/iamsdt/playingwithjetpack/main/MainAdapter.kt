package com.iamsdt.playingwithjetpack.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.iamsdt.playingwithjetpack.R
import kotlinx.android.synthetic.main.main_item.view.*

class MainAdapter(val click: Click) : ListAdapter<String, MainAdapter.VH>(diff_callback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.main_item, parent, false)

        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val string = getItem(position)

        string?.let {
            holder.bind(it)
        }
    }

    interface Click {
        fun click(position: Int)
    }

    companion object {
        val diff_callback = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                //if length is same then items are same too
                return oldItem.length == newItem.length
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

        }
    }

    inner class VH(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        private val tv: TextView = view.main_tv

        init {
            tv.setOnClickListener(this)
        }

        //bind string with view
        fun bind(string: String) {
            tv.text = string
        }

        override fun onClick(v: View?) {
            click.click(adapterPosition)
        }


    }
}
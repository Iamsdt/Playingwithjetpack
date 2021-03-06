/*
 * Developed By Shudipto Trafder
 * at 9/9/18 10:40 PM
 * Copyright (c) 9/9/18 10:40 PM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.paging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.iamsdt.playingwithjetpack.R
import com.iamsdt.playingwithjetpack.base.data.retrofit.pojo.Photos
import kotlinx.android.synthetic.main.page_item.view.*

class PAdapter : PagedListAdapter<Photos, PAdapter.PageVH>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageVH {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.page_item, parent)

        return PageVH(view)
    }

    override fun onBindViewHolder(holder: PageVH, position: Int) {
        val posts: Photos? = getItem(position)
        //handle null value
        //if post is null then don't bind
        posts?.let(holder::bind)
    }


    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Photos>() {
            override fun areItemsTheSame(oldItem: Photos, newItem: Photos): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Photos, newItem: Photos): Boolean {
                return oldItem == newItem
            }

        }
    }

    inner class PageVH(view: View) : RecyclerView.ViewHolder(view) {
        private val titleTV: TextView = view.page_title
        private val bodyTV: TextView = view.page_body

        //used for future reference
        var photos: Photos? = null

        //bind with ui
        fun bind(photos: Photos) {
            this.photos = photos

            titleTV.text = photos.title
            //no sense
            //just show url
            bodyTV.text = photos.thumbnailUrl
        }
    }
}
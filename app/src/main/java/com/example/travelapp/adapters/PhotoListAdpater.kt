package com.example.travelapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.travelapp.R
import com.example.travelapp.views.viewholder.PhotoViewHolder

class PhotoListAdpater : BaseRecyclerAdapter<PhotoViewHolder, String>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_item,parent,false)
        return PhotoViewHolder(view)

    }
}
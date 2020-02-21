package com.example.travelapp.views.viewholder

import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.photo_item.view.*

class PhotoViewHolder(itemView : View):BaseViewHolder<String>(itemView) {
    override fun bindData(data: String) {
        mData = data

        Glide.with(itemView.context)
            .load(data)
            .centerCrop()
            .into(itemView.ivCountry)
    }
}
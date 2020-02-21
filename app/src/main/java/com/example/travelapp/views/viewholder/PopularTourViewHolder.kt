package com.example.travelapp.views.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.example.travelapp.data.vos.CountryVO
import com.example.travelapp.delegates.TourItemDelegate
import kotlinx.android.synthetic.main.popular_tour_item.view.*

class PopularTourViewHolder (itemView : View, delegate : TourItemDelegate)
    : BaseViewHolder<CountryVO>(itemView)
{
    init {
        itemView.setOnClickListener {
            mData?.let {
                delegate.onTapTourItem(it.name)
            }

        }
    }
    override fun bindData(data: CountryVO) {
      mData  = data

        Glide.with(itemView.context)
            .load(data.photos[0])
            .centerCrop()
            .into(itemView.ivPopularTour)

        itemView.tvCountry.text = data.location.split(",").last()
        itemView.tvRating.text = data.averageRating.toString()


    }
}
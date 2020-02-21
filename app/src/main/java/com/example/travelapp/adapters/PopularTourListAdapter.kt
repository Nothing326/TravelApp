package com.example.travelapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.travelapp.R
import com.example.travelapp.data.vos.CountryVO
import com.example.travelapp.delegates.TourItemDelegate
import com.example.travelapp.views.viewholder.BaseViewHolder
import com.example.travelapp.views.viewholder.PopularTourViewHolder

class PopularTourListAdapter (delegate: TourItemDelegate)
    : BaseRecyclerAdapter<BaseViewHolder<CountryVO>,CountryVO>() {

    val mDelegate : TourItemDelegate = delegate
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<CountryVO> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.popular_tour_item,parent,false)

        return PopularTourViewHolder(view,mDelegate)
    }
}
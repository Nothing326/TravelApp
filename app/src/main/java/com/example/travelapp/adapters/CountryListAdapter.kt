package com.example.travelapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.travelapp.R
import com.example.travelapp.data.vos.CountryVO
import com.example.travelapp.delegates.TourItemDelegate
import com.example.travelapp.views.viewholder.BaseViewHolder
import com.example.travelapp.views.viewholder.CountryViewHolder

class CountryListAdapter(delegate : TourItemDelegate): BaseRecyclerAdapter<BaseViewHolder<CountryVO>,CountryVO>() {

    private val mDelegate : TourItemDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<CountryVO> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country_item,parent,false)
        return CountryViewHolder(view,mDelegate)
    }
}
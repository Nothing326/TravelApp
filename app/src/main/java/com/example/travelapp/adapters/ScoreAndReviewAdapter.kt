package com.example.travelapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.travelapp.R
import com.example.travelapp.data.vos.ScoreAndReviewVO
import com.example.travelapp.views.viewholder.BaseViewHolder
import com.example.travelapp.views.viewholder.ScoreAndReviewViewHolder

class ScoreAndReviewAdapter :
    BaseRecyclerAdapter<BaseViewHolder<ScoreAndReviewVO>, ScoreAndReviewVO>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ScoreAndReviewVO> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.booking_item,parent,false)

        return ScoreAndReviewViewHolder(view)
    }
}
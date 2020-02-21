package com.example.travelapp.views.viewholder

import android.view.View
import com.example.travelapp.data.vos.ScoreAndReviewVO
import kotlinx.android.synthetic.main.booking_item.view.*

class ScoreAndReviewViewHolder(itemView : View):BaseViewHolder<ScoreAndReviewVO>(itemView) {

    override fun bindData(data: ScoreAndReviewVO) {
        mData = data
        itemView.tvTitle.text = data.name
        itemView.tvRating.text = data.score.toString()+"/"+data.maxScore

    }
}
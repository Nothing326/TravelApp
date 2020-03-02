package com.example.travelapp.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide

import com.example.travelapp.R
import com.example.travelapp.adapters.PhotoListAdpater
import com.example.travelapp.adapters.ScoreAndReviewAdapter
import com.example.travelapp.data.models.CountryModel
import com.example.travelapp.data.models.CountryModelImpl
import kotlinx.android.synthetic.main.fragment_detail.view.*

/**
 * A simple [Fragment] subclass.
 */
private const val ARG_PARAM1 = "param1"
class DetailFragment: Fragment(){
private lateinit var scoreAndReviewAdapter :ScoreAndReviewAdapter
private lateinit var photoAdapter:PhotoListAdpater
    val mCountryModel : CountryModel = CountryModelImpl
    var countryName : String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_detail, container, false)

        arguments?.let {
            countryName = it.getString(ARG_PARAM1).toString()
        }

        setUpRecycler(view)

        requestData(view)

        backSetting(view)

        return view
    }

    private fun setUpRecycler(view : View){
       scoreAndReviewAdapter = ScoreAndReviewAdapter()
        photoAdapter = PhotoListAdpater()

        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val layoutManagerForPhoto = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        view.rvScoreAndReview.layoutManager = layoutManager
        view.rvPhoto.layoutManager = layoutManagerForPhoto
        view.rvScoreAndReview.adapter = scoreAndReviewAdapter
        view.rvPhoto.adapter = photoAdapter

    }

    private fun requestData(view:View){
        mCountryModel.getDataByName(countryName).observe(this, Observer {
            it?.let {countryVO ->

                view.tvTitle.text = countryVO.name
                view.tvPlace.text = countryVO.location
                view.rb.rating = countryVO.averageRating.toFloat()
                Glide.with(this)
                    .load(countryVO.photos[0])
                    .centerCrop()
                    .into(view.expandedImage)

                view.tvDescription.text = countryVO.description
                scoreAndReviewAdapter.setNewData(countryVO.scoresAndReviews)
                photoAdapter.setNewData(countryVO.photos)

            }
        }
            )
    }

    private fun backSetting(view: View){
        view.ivBack.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }
    }
    companion object {
        @JvmStatic
        fun newInstance(name: String) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, name)
                }
            }
    }

}

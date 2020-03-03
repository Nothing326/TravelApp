package com.example.travelapp.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.travelapp.R
import com.example.travelapp.adapters.CountryListAdapter
import com.example.travelapp.adapters.PopularTourListAdapter
import com.example.travelapp.data.models.CountryModel
import com.example.travelapp.data.models.CountryModelImpl
import com.example.travelapp.delegates.TourItemDelegate
import com.example.travelapp.views.viewpods.EmptyViewPod
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
private const val ARG_PARAM1 = "param1"
class HomeFragment : Fragment(),TourItemDelegate {


    private  lateinit var  mCountryListAdapter : CountryListAdapter
    private  lateinit var  mPopularTourListAdapter : PopularTourListAdapter
    private  val mCountryModel : CountryModel = CountryModelImpl

    private lateinit var viewPodEmpty : EmptyViewPod

    private val compositeDisposable = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setUpEmptyViewPod()
        hideEmptyView()

        setUpRecyclerViewForCountry()

        requestData()

        setUpRecyclerViewForPopularTour()
    }

    private fun setUpRecyclerViewForCountry(){
        mCountryListAdapter = CountryListAdapter(this)

        val linearLayoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        rvCountries.layoutManager = linearLayoutManager
        rvCountries.adapter = mCountryListAdapter
    }


    private fun setUpRecyclerViewForPopularTour(){
        mPopularTourListAdapter = PopularTourListAdapter(this)
        val linearLayoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        rvPopularTour.layoutManager = linearLayoutManager
        rvPopularTour.adapter = mPopularTourListAdapter
    }



    private fun requestData(){
        swipeRefreshLayout.isRefreshing = true

        mCountryModel.getAllPopularTourAndCountry()
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe {
                  if (it.country.isNotEmpty()|| it.popularTour.isNotEmpty()) {
                      hideEmptyView()

                      swipeRefreshLayout.isRefreshing = false
                      mCountryListAdapter.setNewData(it.country)
                      mPopularTourListAdapter.setNewData(it.popularTour)
                  } else {
                      showEmptyView()
                  }

              }.addTo(compositeDisposable)


    }


    companion object {
        @JvmStatic
        fun newInstance(name: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, name)
                }
            }
    }

    override fun onTapTourItem(countryName: String) {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.frameLayout, DetailFragment.newInstance(countryName))?.addToBackStack(null)
            ?.commit()
    }

    private fun hideEmptyView(){
        viewPodEmpty.visibility = View.GONE
    }
    private fun showEmptyView(){
        viewPodEmpty.visibility = View.VISIBLE
    }
    private fun setUpEmptyViewPod(){
        viewPodEmpty = vpEmpty as EmptyViewPod
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}

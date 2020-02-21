package com.example.travelapp.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate
import com.example.travelapp.R
import com.example.travelapp.data.models.CountryModel
import com.example.travelapp.data.models.CountryModelImpl
import com.example.travelapp.delegates.TourItemDelegate
import com.example.travelapp.fragments.DetailFragment
import com.example.travelapp.fragments.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initial HomeFragment
        openFragment(HomeFragment.newInstance(""))
        setUpBottomNavigation()

    }
    private fun setUpBottomNavigation(){
        bottomNavigation.setOnNavigationItemSelectedListener(
            object : BottomNavigationView.OnNavigationItemSelectedListener {
                override fun onNavigationItemSelected(item: MenuItem): Boolean {
                    when (item.itemId) {
                        R.id.bottom_nav_home -> {
                            openFragment(HomeFragment.newInstance(""))
                            return true
                        }


                    }
                    return false
                }
            }
        )
    }


    fun openFragment(fm: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fm)
            .commit()
    }


}

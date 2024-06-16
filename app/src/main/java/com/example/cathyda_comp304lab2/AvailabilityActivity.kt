package com.example.cathyda_comp304lab2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class AvailabilityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_availability)

        val message = intent.getIntExtra(EXTRA_MESSAGE, 0)

        when(message){
            1 -> { showFragmentListing(ApartmentListingFragment()) }
            2 -> { showFragmentListing(DetachedListingFragment()) }
            3 -> { showFragmentListing(SemiDetachedListingFragment()) }
            4 -> { showFragmentListing(CondominiumListingFragment()) }
            5 -> { showFragmentListing(TownHouseListingFragment()) }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.apartment -> { showFragmentListing(ApartmentListingFragment()) }
            R.id.detachedhome -> { showFragmentListing(DetachedListingFragment()) }
            R.id.semidetachedhome -> { showFragmentListing(SemiDetachedListingFragment()) }
            R.id.condominiumapartment -> { showFragmentListing(CondominiumListingFragment()) }
            R.id.townhouse -> { showFragmentListing(TownHouseListingFragment()) }
        }
        return true
    }

    fun showFragmentListing(fragmentView: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.frgListing, fragmentView)
            .commit()
    }
}
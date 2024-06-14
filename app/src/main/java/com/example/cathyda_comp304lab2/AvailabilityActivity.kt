package com.example.cathyda_comp304lab2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AvailabilityActivity : AppCompatActivity() {

    val args = Bundle()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_availability)

        val message = intent.getIntExtra(EXTRA_MESSAGE, 0)

        val displayFragment = supportFragmentManager.findFragmentById(R.id.frgListing)
                as ListingFragment

//        when(message){
//            1 -> text = "Apartment"
//            2 -> text = "Detached Home"
//            3 -> text = "Semi-detached Home"
//            4 -> text = "Condominium Apartment"
//            5 -> text = "Town House"
//
//        }
        args.putInt("homeType", message)

        displayFragment.arguments = args
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.apartment -> {
                val displayFragment = supportFragmentManager.findFragmentById(R.id.frgListing)
                        as ListingFragment

                args.putInt("homeType", 1)

                displayFragment.arguments = args
            }
            R.id.detachedhome -> {
                val displayFragment = supportFragmentManager.findFragmentById(R.id.frgListing)
                        as ListingFragment

                args.putInt("homeType", 2)

                displayFragment.arguments = args
            }
            R.id.semidetachedhome -> {
                val displayFragment = supportFragmentManager.findFragmentById(R.id.frgListing)
                        as ListingFragment

                args.putInt("homeType", 3)

                displayFragment.arguments = args
            }
            R.id.condominiumapartment -> {
                val displayFragment = supportFragmentManager.findFragmentById(R.id.frgListing)
                        as ListingFragment

                args.putInt("homeType", 4)

                displayFragment.arguments = args
            }
            R.id.townhouse -> {
                val displayFragment = supportFragmentManager.findFragmentById(R.id.frgListing)
                        as ListingFragment

                args.putInt("homeType", 5)

                displayFragment.arguments = args
            }
            else -> {
                val displayFragment = supportFragmentManager.findFragmentById(R.id.frgListing)
                        as ListingFragment

                args.putInt("homeType", 1)

                displayFragment.arguments = args
            }
        }
        return true
    }
}
package com.example.cathyda_comp304lab2

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible

class CheckoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)
    }

    override fun onStart() {
        super.onStart()
        setSelectedHomes()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.apartment -> { sendHomeType(1) }
            R.id.detachedhome -> { sendHomeType(2) }
            R.id.semidetachedhome -> { sendHomeType(3) }
            R.id.condominiumapartment -> { sendHomeType(4) }
            R.id.townhouse -> { sendHomeType(5) }
        }
        return true
    }

    fun sendHomeType(homeType : Int) {
        val intent = Intent(this, AvailabilityActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, homeType)
        }
        startActivity(intent)
    }

    fun setSelectedHomes(){
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
        val homes = sharedPreferences.all

        var homeTyped: Int
        var priceTyped: Int
        var addressTyped: Int
        var bedroomTyped: Int
        var bathroomTyped: Int
        var imageTyped: Int

        var cardTyped: Int

        //counter
        var i = 1

        for (home in homes.keys){

            homeTyped = resources.getIdentifier(home,"array", applicationContext.packageName)
            priceTyped = resources.getIdentifier("txtPrice$i", "id", applicationContext.packageName)
            addressTyped = resources.getIdentifier("txtAddress$i", "id", applicationContext.packageName)
            bedroomTyped = resources.getIdentifier("txtBedrooms$i", "id", applicationContext.packageName)
            bathroomTyped = resources.getIdentifier("txtBathrooms$i", "id", applicationContext.packageName)
            imageTyped = resources.getIdentifier("imgListing$i","id", applicationContext.packageName)

            setListingInfo(homeTyped, priceTyped, addressTyped, bedroomTyped, bathroomTyped, imageTyped)

            cardTyped = resources.getIdentifier("cardListing$i","id",applicationContext.packageName)
            val cardView: CardView = findViewById(cardTyped)

            cardView.isVisible = true

            i += 1
        }
    }

    fun setListingInfo (listingId: Int,
                        priceId: Int,
                        addressId: Int,
                        bedroomId: Int,
                        bathroomId: Int,
                        imageId: Int)
    {
        val listingInfo: Array<String> = resources.getStringArray(listingId)

        val price: String = listingInfo[0]
        val priceView: TextView = findViewById(priceId)
        priceView.text = price

        val address: String = listingInfo[1]
        val addressView: TextView = findViewById(addressId)
        addressView.text = address

        val bedrooms: String = listingInfo[2]
        val bedroomsView: TextView = findViewById(bedroomId)
        bedroomsView.text = bedrooms

        val bathrooms: String = listingInfo[3]
        val bathroomsView: TextView = findViewById(bathroomId)
        bathroomsView.text = bathrooms

        //retrieving array as a TypedArray for the image resource
        val image: TypedArray = resources.obtainTypedArray(listingId)
        val imageView: ImageView = findViewById(imageId)
        imageView.setImageResource(image.getResourceId(4,0))
    }
}
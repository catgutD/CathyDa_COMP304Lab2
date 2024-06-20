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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CheckoutActivity : AppCompatActivity() {
    val listingsList = ArrayList<String>()
    lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        val recyclerView: RecyclerView = findViewById(R.id.recycleListing)
        customAdapter = CustomAdapter(listingsList, applicationContext)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter
        prepareHomes()
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

    fun prepareHomes() {
        val initialSize = listingsList.size
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
        val homes = sharedPreferences.all

        for (home in homes.keys){ listingsList.add(home) }

        customAdapter.notifyItemRangeInserted(initialSize, listingsList.size - initialSize)
    }
}
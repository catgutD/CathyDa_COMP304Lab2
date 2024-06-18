package com.example.cathyda_comp304lab2

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class CheckoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)
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
}
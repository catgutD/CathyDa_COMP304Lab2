package com.example.cathyda_comp304lab2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AvailabilityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_availability)

        val message = intent.getIntExtra(EXTRA_MESSAGE, 0)

        findViewById<TextView>(R.id.textView).apply {
            when(message){
                1 -> text = "Apartment"
                2 -> text = "Detached Home"
                3 -> text = "Semi-detached Home"
                4 -> text = "Condominium Apartment"
                5 -> text = "Town House"
            }
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
            R.id.apartment -> findViewById<TextView>(R.id.textView).apply {text = "Apartment"}
            R.id.detachedhome -> findViewById<TextView>(R.id.textView).apply {text = "Detached Home"}
            R.id.semidetachedhome -> findViewById<TextView>(R.id.textView).apply {text = "Semi-detached Home"}
            R.id.condominiumapartment -> findViewById<TextView>(R.id.textView).apply {text = "Condominium Apartment"}
            R.id.townhouse -> findViewById<TextView>(R.id.textView).apply {text = "Town House"}
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }
}
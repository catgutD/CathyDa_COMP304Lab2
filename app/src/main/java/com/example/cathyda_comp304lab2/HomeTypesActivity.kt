package com.example.cathyda_comp304lab2

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeTypesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_types)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.apartment -> Toast.makeText(this, "You selected Apartment!", Toast.LENGTH_LONG).show()
            R.id.detachedhome -> Toast.makeText(this, "You selected Detached Home!", Toast.LENGTH_LONG).show()
            R.id.semidetachedhome -> Toast.makeText(this, "You selected Semi-detached Home!", Toast.LENGTH_LONG)
                .show()
            R.id.condominiumapartment -> Toast.makeText(this, "You selected Condominium Apartment!", Toast.LENGTH_SHORT).show()
            R.id.townhouse -> Toast.makeText(this, "You selected Town House!", Toast.LENGTH_LONG).show()
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }
}
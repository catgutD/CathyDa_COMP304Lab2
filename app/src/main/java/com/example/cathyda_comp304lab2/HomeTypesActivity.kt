package com.example.cathyda_comp304lab2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

const val EXTRA_MESSAGE ="com.android.HOMETYPE"
class HomeTypesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_types)

        val radioHomeTypes : RadioGroup = findViewById<View>(R.id.radioHomeTypes) as RadioGroup
        var homeType = 0
        val btnSubmit : Button = findViewById<View>(R.id.btnSubmit) as Button


        btnSubmit.setOnClickListener{
            val id = radioHomeTypes.checkedRadioButtonId
            when(id){
                R.id.radioApartment -> homeType = 1
                R.id.radioDetachedHome -> homeType = 2
                R.id.radioSemiDetached -> homeType = 3
                R.id.radioCondominium -> homeType = 4
                R.id.radioTownHouse -> homeType = 5
            }
            sendHomeType(homeType)
        }
    }


    fun sendHomeType(homeType : Int) {
        val intent = Intent(this, AvailabilityActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, homeType)
        }
        startActivity(intent)
    }
}
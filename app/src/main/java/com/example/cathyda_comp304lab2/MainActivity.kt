package com.example.cathyda_comp304lab2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEnter: Button = findViewById<View>(R.id.btnEnter) as Button
        btnEnter.setOnClickListener{
                val intent = Intent(this, HomeTypesActivity::class.java)
                startActivity(intent)
        }

    }

}
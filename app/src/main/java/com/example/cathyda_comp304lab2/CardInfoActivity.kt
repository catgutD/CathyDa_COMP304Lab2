package com.example.cathyda_comp304lab2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.Toast

class CardInfoActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_info)

    }

    fun validateInput(){
        val fullName: EditText = findViewById(R.id.txtInputFullName)
        val cardNumber: EditText = findViewById(R.id.txtInputNumber)
        val answer1: EditText = findViewById(R.id.txtInputAnswer1)
        val answer2: EditText = findViewById(R.id.txtInputAnswer2)
        val answer3: EditText = findViewById(R.id.txtInputAnswer3)

        if(fullName.text.isEmpty()){
            Toast.makeText(this, R.string.empty_fullname_input_alert, Toast.LENGTH_LONG)
                 .show()
        }
        if(cardNumber.text.isEmpty()){
            Toast.makeText(this, R.string.empty_cardnumber_input_alert, Toast.LENGTH_LONG)
                 .show()
        }
        if(answer1.text.isEmpty() or answer2.text.isEmpty() or answer3.text.isEmpty()){
            Toast.makeText(this, R.string.empty_answer_alert, Toast.LENGTH_LONG)
                 .show()
        }
    }
}

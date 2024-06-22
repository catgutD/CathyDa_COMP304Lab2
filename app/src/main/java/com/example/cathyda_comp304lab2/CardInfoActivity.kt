package com.example.cathyda_comp304lab2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.Toast

class CardInfoActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_info)

        val btnSubmitCard: Button = findViewById(R.id.btnSubmitCard) as Button
        btnSubmitCard.setOnClickListener{
            if(validateInput()){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    fun validateInput(): Boolean{
        val fullName: EditText = findViewById(R.id.txtInputFullName)
        val cardNumber: EditText = findViewById(R.id.txtInputNumber)
        val answer1: EditText = findViewById(R.id.txtInputAnswer1)
        val answer2: EditText = findViewById(R.id.txtInputAnswer2)
        val answer3: EditText = findViewById(R.id.txtInputAnswer3)

        if(fullName.text.isEmpty()){
            Toast.makeText(this, R.string.empty_fullname_input_alert, Toast.LENGTH_LONG)
                 .show()
            return false
        }
        if(cardNumber.text.isEmpty()){
            Toast.makeText(this, R.string.empty_cardnumber_input_alert, Toast.LENGTH_LONG)
                 .show()
            return false
        }
        if(answer1.text.isEmpty()){
            Toast.makeText(this, R.string.empty_answer_alert, Toast.LENGTH_LONG)
                .show()
            return false
        }
        if(answer2.text.isEmpty()){
            Toast.makeText(this, R.string.empty_answer_alert, Toast.LENGTH_LONG)
                .show()
            return false
        }
        if(answer3.text.isEmpty()){
            Toast.makeText(this, R.string.empty_answer_alert, Toast.LENGTH_LONG)
                .show()
            return false
        }
        return true
    }
}

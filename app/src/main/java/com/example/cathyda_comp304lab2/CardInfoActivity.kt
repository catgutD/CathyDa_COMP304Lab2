package com.example.cathyda_comp304lab2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.Toast

const val EXTRA_CARD_INFO = "com.android.CARDINFO"
class CardInfoActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_info)

        val fullName: EditText = findViewById(R.id.txtInputFullName)
        val cardNumber: EditText = findViewById(R.id.txtInputNumber)
        val answer1: EditText = findViewById(R.id.txtInputAnswer1)
        val answer2: EditText = findViewById(R.id.txtInputAnswer2)
        val answer3: EditText = findViewById(R.id.txtInputAnswer3)

        val btnSubmitCard: Button = findViewById(R.id.btnSubmitCard)
        btnSubmitCard.setOnClickListener{
            if(validateInput(fullName, cardNumber, answer1, answer2, answer3))
            {
                val cardInfoArray : Array<String> = arrayOf(fullName.text.toString(),
                                                            cardNumber.text.toString(),
                                                            answer1.text.toString(),
                                                            answer2.text.toString(),
                                                            answer3.text.toString())

                val intent = Intent(this, CompletionActivity::class.java).apply {
                    putExtra(EXTRA_CARD_INFO, cardInfoArray)
                }
                startActivity(intent)
            }
        }
    }

    fun validateInput(
        fullName: EditText,
        cardNumber: EditText,
        a1: EditText,
        a2: EditText,
        a3: EditText
    ): Boolean
    {
        if(fullName.text.isEmpty())
        {
            Toast.makeText(this, R.string.empty_fullname_input_alert, Toast.LENGTH_LONG)
                 .show()
            return false
        }
        if(cardNumber.text.isEmpty())
        {
            Toast.makeText(this, R.string.empty_cardnumber_input_alert, Toast.LENGTH_LONG)
                 .show()
            return false
        }
        if(a1.text.isEmpty())
        {
            Toast.makeText(this, R.string.empty_answer_alert, Toast.LENGTH_LONG)
                .show()
            return false
        }
        if(a2.text.isEmpty())
        {
            Toast.makeText(this, R.string.empty_answer_alert, Toast.LENGTH_LONG)
                .show()
            return false
        }
        if(a3.text.isEmpty())
        {
            Toast.makeText(this, R.string.empty_answer_alert, Toast.LENGTH_LONG)
                .show()
            return false
        }
        return true
    }
}

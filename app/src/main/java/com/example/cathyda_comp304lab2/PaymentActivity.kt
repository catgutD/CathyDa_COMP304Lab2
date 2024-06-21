package com.example.cathyda_comp304lab2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class PaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        val radioPayment: RadioGroup = findViewById<View>(R.id.radioPaymentType) as RadioGroup
        val btnPay: Button = findViewById<View>(R.id.btnPayment) as Button

        when(radioPayment.checkedRadioButtonId){
            R.id.radioCreditCard -> btnPay.isEnabled = true
            R.id.radioDebitCard -> btnPay.isEnabled = true
            else -> btnPay.isEnabled = false
        }

        btnPay.setOnClickListener{

        }
    }
}
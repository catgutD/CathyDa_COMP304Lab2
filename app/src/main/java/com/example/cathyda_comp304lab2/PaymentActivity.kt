package com.example.cathyda_comp304lab2

import android.content.Intent
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

        radioPayment.setOnCheckedChangeListener { _, checkedId -> btnPay.isEnabled = true }

        btnPay.setOnClickListener{
            if(radioPayment.checkedRadioButtonId == R.id.radioCash){
                val intent = Intent(this, CompletionActivity::class.java)
                startActivity(intent)
            }
            else{
                val intent = Intent(this, CardInfoActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
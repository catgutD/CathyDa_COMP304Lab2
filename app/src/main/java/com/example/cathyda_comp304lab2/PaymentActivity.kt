package com.example.cathyda_comp304lab2

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

const val EXTRA_PAYMENT_TYPE ="com.android.PAYMENTTYPE"
class PaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        val radioPayment: RadioGroup = findViewById<View>(R.id.radioPaymentType) as RadioGroup
        val btnPay: Button = findViewById<View>(R.id.btnPayment) as Button

        radioPayment.setOnCheckedChangeListener { _, checkedId -> btnPay.isEnabled = true }

        btnPay.setOnClickListener{
            when(radioPayment.checkedRadioButtonId){
                R.id.radioCash -> {
                    val intent = Intent(this, CompletionActivity::class.java).apply {
                        putExtra(EXTRA_PAYMENT_TYPE, "Cash")
                    }
                    startActivity(intent)
                }
                R.id.radioCreditCard -> {
                    setPreferencePayment("Credit Card")
                    val intent = Intent(this, CardInfoActivity::class.java)
                    startActivity(intent)
                }
                R.id.radioDebitCard -> {
                    setPreferencePayment("Debit Card")
                    val intent = Intent(this, CardInfoActivity::class.java)
                    startActivity(intent)

                }
            }
        }
    }

    fun setPreferencePayment(paymentType: String)
    {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val editor = sharedPreferences.edit()
        editor.putString("payment", paymentType)
            .apply()
    }
}
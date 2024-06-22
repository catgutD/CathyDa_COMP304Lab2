package com.example.cathyda_comp304lab2

import android.annotation.SuppressLint
import android.content.res.TypedArray
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CompletionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_completion)

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)

        val payment = intent.getStringExtra(EXTRA_PAYMENT_TYPE)

        val selectedHome = sharedPreferences.getInt("selected", 0)
        setSelectedInfo(selectedHome)

        if(payment == "Cash"){
            setCardInfo(payment, "N/A", "N/A", "N/A", "N/A", "N/A")
        }
        else {
            val paymentCard = sharedPreferences.getString("payment", "")
            val cardInfo = intent.getStringArrayExtra(EXTRA_CARD_INFO)
            setCardInfo(paymentCard, cardInfo!![0], cardInfo[1], cardInfo[2], cardInfo[3], cardInfo[4])
        }
    }

    @SuppressLint("ResourceType")
    fun setSelectedInfo(selectedInfo: Int){
        val info: Array<String> = resources.getStringArray(selectedInfo)

        val price: TextView = findViewById(R.id.txtChosenPrice)
        val address: TextView = findViewById(R.id.txtChosenAddress)
        val bedrooms: TextView = findViewById(R.id.txtChosenBedrooms)
        val bathrooms: TextView = findViewById(R.id.txtChosenBathrooms)
        val img: ImageView = findViewById(R.id.imgSelectedListing)

        price.text = info[0]
        address.text = info[1]
        bedrooms.text = info[2]
        bathrooms.text = info[3]

        val image: TypedArray = resources.obtainTypedArray(selectedInfo)
        img.setImageResource(image.getResourceId(4,0))
    }

    fun setCardInfo(
        payment: String?,
        name: String,
        card: String,
        answer1: String,
        answer2: String,
        answer3: String)
    {
        val paymentType: TextView = findViewById(R.id.txtPaymentType)
        val fullName: TextView = findViewById(R.id.txtFullNameComplete)
        val cardNumber: TextView = findViewById(R.id.txtCardNumberCompletion)
        val a1: TextView = findViewById(R.id.txtAnswerCompletion)
        val a2: TextView = findViewById(R.id.txtAnswer2Completion)
        val a3: TextView = findViewById(R.id.txtAnswer3Completion)

        paymentType.text = payment
        fullName.text = name
        cardNumber.text = card
        a1.text = answer1
        a2.text = answer2
        a3.text = answer3
    }
}
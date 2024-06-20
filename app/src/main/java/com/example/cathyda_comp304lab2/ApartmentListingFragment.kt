package com.example.cathyda_comp304lab2

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.fragment.app.Fragment

class ApartmentListingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_apartment_listing, container, false)
        return view
    }

    override fun onStart() {
        super.onStart()

        setApartmentInfo(
            R.array.apartment_1,
            R.id.txtPrice1,
            R.id.txtAddress1,
            R.id.txtBedrooms1,
            R.id.txtBathrooms1
        )
        setApartmentInfo(
            R.array.apartment_2,
            R.id.txtPrice2,
            R.id.txtAddress2,
            R.id.txtBedrooms2,
            R.id.txtBathrooms2
        )
        setApartmentInfo(
            R.array.apartment_3,
            R.id.txtPrice3,
            R.id.txtAddress3,
            R.id.txtBedrooms3,
            R.id.txtBathrooms3
        )
        val chkApartment1 : CheckBox? = view?.findViewById(R.id.chbxApartment1)
        val chkApartment2 : CheckBox? = view?.findViewById(R.id.chbxApartment2)
        val chkApartment3 : CheckBox? = view?.findViewById(R.id.chbxApartment3)

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

        loadCheckedApartment(sharedPreferences)

        val editor = sharedPreferences.edit()

        chkApartment1?.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                editor.putBoolean("apartment1", true)
                    .apply()
            }
            else{
                editor.remove("apartment1")
                    .apply()

            }
        }

        chkApartment2?.setOnCheckedChangeListener { buttonView, isChecked ->
            if(chkApartment2.isChecked){
                editor.putBoolean("apartment2", true)
                    .apply()
            }
            else{
                editor.remove("apartment2")
                    .apply()

            }
        }

        chkApartment3?.setOnCheckedChangeListener { buttonView, isChecked ->
            if(chkApartment3.isChecked){
                editor.putBoolean("apartment3", true)
                    .apply()
            }
            else{
                editor.remove("apartment3")
                    .apply()

            }
        }
    }

    fun setApartmentInfo(apartmentId: Int, priceId: Int, addressId: Int, bedroomId: Int, bathroomId: Int){
        val apartmentInfo: Array<String> = resources.getStringArray(apartmentId)

        val price: String = apartmentInfo[0]
        val priceView: TextView? = view?.findViewById(priceId)
        priceView?.text = price

        val address: String = apartmentInfo[1]
        val addressView: TextView? = view?.findViewById(addressId)
        addressView?.text = address

        val bedrooms: String = apartmentInfo[2]
        val bedroomsView: TextView? = view?.findViewById(bedroomId)
        bedroomsView?.text = bedrooms

        val bathrooms: String = apartmentInfo[3]
        val bathroomsView: TextView? = view?.findViewById(bathroomId)
        bathroomsView?.text = bathrooms
    }

    fun loadCheckedApartment(sharedPreferences : SharedPreferences){
        if(sharedPreferences.contains("apartment1")){ view?.findViewById<CheckBox>(R.id.chbxApartment1)?.isChecked = true }
        if(sharedPreferences.contains("apartment2")){ view?.findViewById<CheckBox>(R.id.chbxApartment2)?.isChecked = true }
        if(sharedPreferences.contains("apartment3")){ view?.findViewById<CheckBox>(R.id.chbxApartment3)?.isChecked = true }
    }
}
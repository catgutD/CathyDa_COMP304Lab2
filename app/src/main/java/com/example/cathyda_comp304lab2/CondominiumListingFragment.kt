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

class CondominiumListingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_condominium_apartment_listing, container, false)
        return view
    }

    override fun onStart() {
        super.onStart()

        setCondominiumInfo(
            R.array.condo_1,
            R.id.txtPrice1,
            R.id.txtAddress1,
            R.id.txtBedrooms1,
            R.id.txtBathrooms1
        )
        setCondominiumInfo(
            R.array.condo_2,
            R.id.txtPrice2,
            R.id.txtAddress2,
            R.id.txtBedrooms2,
            R.id.txtBathrooms2
        )
        setCondominiumInfo(
            R.array.condo_3,
            R.id.txtPrice3,
            R.id.txtAddress3,
            R.id.txtBedrooms3,
            R.id.txtBathrooms3
        )
        val chkCondominium1 : CheckBox? = view?.findViewById(R.id.chbxCondo1)
        val chkCondominium2 : CheckBox? = view?.findViewById(R.id.chbxCondo2)
        val chkCondominium3 : CheckBox? = view?.findViewById(R.id.chbxCondo3)

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

        loadCheckedCondominium(sharedPreferences)

        val editor = sharedPreferences.edit()

        chkCondominium1?.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                editor.putBoolean("condo1", true)
                    .apply()
            }
            else{
                editor.remove("condo1")
                    .apply()

            }
        }

        chkCondominium2?.setOnCheckedChangeListener { buttonView, isChecked ->
            if(chkCondominium2.isChecked){
                editor.putBoolean("condo2", true)
                    .apply()
            }
            else{
                editor.remove("condo2")
                    .apply()

            }
        }

        chkCondominium3?.setOnCheckedChangeListener { buttonView, isChecked ->
            if(chkCondominium3.isChecked){
                editor.putBoolean("condo3", true)
                    .apply()
            }
            else{
                editor.remove("condo3")
                    .apply()

            }
        }
    }

    fun setCondominiumInfo(condominiumId: Int, priceId: Int, addressId: Int, bedroomId: Int, bathroomId: Int){
        val condominiumInfo: Array<String> = resources.getStringArray(condominiumId)

        val price: String = condominiumInfo[0]
        val priceView: TextView? = view?.findViewById(priceId)
        priceView?.text = price

        val address: String = condominiumInfo[1]
        val addressView: TextView? = view?.findViewById(addressId)
        addressView?.text = address

        val bedrooms: String = condominiumInfo[2]
        val bedroomsView: TextView? = view?.findViewById(bedroomId)
        bedroomsView?.text = bedrooms

        val bathrooms: String = condominiumInfo[3]
        val bathroomsView: TextView? = view?.findViewById(bathroomId)
        bathroomsView?.text = bathrooms
    }

    fun loadCheckedCondominium(sharedPreferences : SharedPreferences){
        if(sharedPreferences.contains("condo1")){ view?.findViewById<CheckBox>(R.id.chbxCondo1)?.isChecked = true }
        if(sharedPreferences.contains("condo2")){ view?.findViewById<CheckBox>(R.id.chbxCondo2)?.isChecked = true }
        if(sharedPreferences.contains("condo3")){ view?.findViewById<CheckBox>(R.id.chbxCondo3)?.isChecked = true }
    }
}

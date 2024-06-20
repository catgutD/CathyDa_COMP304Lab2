package com.example.cathyda_comp304lab2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
}

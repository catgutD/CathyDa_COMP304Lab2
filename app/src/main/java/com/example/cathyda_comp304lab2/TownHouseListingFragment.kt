package com.example.cathyda_comp304lab2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class TownHouseListingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_town_house_listing, container, false)
        return  view
    }


    override fun onStart() {
        super.onStart()

        setTownHouseInfo(
            R.array.town_house_1,
            R.id.txtPrice1,
            R.id.txtAddress1,
            R.id.txtBedrooms1,
            R.id.txtBathrooms1
        )
        setTownHouseInfo(
            R.array.town_house_2,
            R.id.txtPrice2,
            R.id.txtAddress2,
            R.id.txtBedrooms2,
            R.id.txtBathrooms2
        )
        setTownHouseInfo(
            R.array.town_house_3,
            R.id.txtPrice3,
            R.id.txtAddress3,
            R.id.txtBedrooms3,
            R.id.txtBathrooms3
        )
    }
    fun setTownHouseInfo(townHouseId: Int, priceId: Int, addressId: Int, bedroomId: Int, bathroomId: Int){
        val townHouseInfo: Array<String> = resources.getStringArray(townHouseId)

        val price: String = townHouseInfo[0]
        val priceView: TextView? = view?.findViewById(priceId)
        priceView?.text = price

        val address: String = townHouseInfo[1]
        val addressView: TextView? = view?.findViewById(addressId)
        addressView?.text = address

        val bedrooms: String = townHouseInfo[2]
        val bedroomsView: TextView? = view?.findViewById(bedroomId)
        bedroomsView?.text = bedrooms

        val bathrooms: String = townHouseInfo[3]
        val bathroomsView: TextView? = view?.findViewById(bathroomId)
        bathroomsView?.text = bathrooms
    }
}

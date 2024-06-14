package com.example.cathyda_comp304lab2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ListingFragment : Fragment() {
    override fun onCreateView(
        inflater : LayoutInflater, container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View? {

        val homeType = arguments?.getInt("homeType")

        val view : View?

        when(homeType){
            1 -> view = inflater.inflate(R.layout.fragment_apartment_listing, container, false)
            2 -> view = inflater.inflate(R.layout.fragment_detached_home_listing, container, false)
            3 -> view = inflater.inflate(R.layout.fragment_semi_detached_home_listing, container, false)
            4 -> view = inflater.inflate(R.layout.fragment_condominium_apartment_listing, container, false)
            5 -> view = inflater.inflate(R.layout.fragment_town_house_listing, container, false)
            else -> view = inflater.inflate(R.layout.fragment_apartment_listing, container, false)
        }

        return view
    }

}
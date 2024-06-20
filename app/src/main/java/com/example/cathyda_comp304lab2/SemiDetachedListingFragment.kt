package com.example.cathyda_comp304lab2

import android.content.SharedPreferences
import android.content.res.TypedArray
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class SemiDetachedListingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_semi_detached_home_listing, container, false)
        return view

    }
    override fun onStart() {
        super.onStart()

        setDetachedInfo(
            R.array.semi_detached_1,
            R.id.txtPrice1,
            R.id.txtAddress1,
            R.id.txtBedrooms1,
            R.id.txtBathrooms1,
            R.id.imgSemiDetached1
        )
        setDetachedInfo(
            R.array.semi_detached_2,
            R.id.txtPrice2,
            R.id.txtAddress2,
            R.id.txtBedrooms2,
            R.id.txtBathrooms2,
            R.id.imgSemiDetached2
        )
        setDetachedInfo(
            R.array.semi_detached_3,
            R.id.txtPrice3,
            R.id.txtAddress3,
            R.id.txtBedrooms3,
            R.id.txtBathrooms3,
            R.id.imgSemiDetached3
        )

        val chkSemiDetached1 : CheckBox? = view?.findViewById(R.id.chbxSemiDetached1)
        val chkSemiDetached2 : CheckBox? = view?.findViewById(R.id.chbxSemiDetached2)
        val chkSemiDetached3 : CheckBox? = view?.findViewById(R.id.chbxSemiDetached3)

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

        loadCheckedSemiDetached(sharedPreferences)

        val editor = sharedPreferences.edit()

        chkSemiDetached1?.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                editor.putBoolean("semiDetached1", true)
                    .apply()
            }
            else{
                editor.remove("semiDetached1")
                      .apply()
            }
        }

        chkSemiDetached2?.setOnCheckedChangeListener { buttonView, isChecked ->
            if(chkSemiDetached2.isChecked){
                editor.putBoolean("semiDetached2", true)
                      .apply()
            }
            else{
                editor.remove("semiDetached2")
                      .apply()
            }
        }

        chkSemiDetached3?.setOnCheckedChangeListener { buttonView, isChecked ->
            if(chkSemiDetached3.isChecked){
                editor.putBoolean("semiDetached3", true)
                      .apply()
            }
            else{
                editor.remove("semiDetached3")
                      .apply()
            }
        }
    }

    fun setDetachedInfo(semiDetachedId: Int,
                        priceId: Int,
                        addressId: Int,
                        bedroomId: Int,
                        bathroomId: Int,
                        imageId: Int){
        val semiDetachedInfo: Array<String> = resources.getStringArray(semiDetachedId)

        val price: String = semiDetachedInfo[0]
        val priceView: TextView? = view?.findViewById(priceId)
        priceView?.text = price

        val address: String = semiDetachedInfo[1]
        val addressView: TextView? = view?.findViewById(addressId)
        addressView?.text = address

        val bedrooms: String = semiDetachedInfo[2]
        val bedroomsView: TextView? = view?.findViewById(bedroomId)
        bedroomsView?.text = bedrooms

        val bathrooms: String = semiDetachedInfo[3]
        val bathroomsView: TextView? = view?.findViewById(bathroomId)
        bathroomsView?.text = bathrooms

        //retrieving array as a TypedArray for the image resource
        val image: TypedArray = resources.obtainTypedArray(semiDetachedId)
        val imageView: ImageView? = view?.findViewById(imageId)
        imageView?.setImageResource(image.getResourceId(4,0))
    }

    fun loadCheckedSemiDetached(sharedPreferences : SharedPreferences){
        if(sharedPreferences.contains("semiDetached1")){ view?.findViewById<CheckBox>(R.id.chbxSemiDetached1)?.isChecked = true }
        if(sharedPreferences.contains("semiDetached2")){ view?.findViewById<CheckBox>(R.id.chbxSemiDetached2)?.isChecked = true }
        if(sharedPreferences.contains("semiDetached3")){ view?.findViewById<CheckBox>(R.id.chbxSemiDetached3)?.isChecked = true }
    }
}
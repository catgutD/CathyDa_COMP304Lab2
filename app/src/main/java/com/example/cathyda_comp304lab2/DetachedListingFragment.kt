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

class DetachedListingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detached_home_listing, container, false)
        return view
    }
    override fun onStart() {
        super.onStart()

        setDetachedInfo(
            R.array.detached_home_1,
            R.id.txtPrice1,
            R.id.txtAddress1,
            R.id.txtBedrooms1,
            R.id.txtBathrooms1,
            R.id.imgDetached1
        )
        setDetachedInfo(
            R.array.detached_home_2,
            R.id.txtPrice2,
            R.id.txtAddress2,
            R.id.txtBedrooms2,
            R.id.txtBathrooms2,
            R.id.imgDetached2
        )
        setDetachedInfo(
            R.array.detached_home_3,
            R.id.txtPrice3,
            R.id.txtAddress3,
            R.id.txtBedrooms3,
            R.id.txtBathrooms3,
            R.id.imgDetached3
        )

        val chkDetached1 : CheckBox? = view?.findViewById(R.id.chbxDetached1)
        val chkDetached2 : CheckBox? = view?.findViewById(R.id.chbxDetached2)
        val chkDetached3 : CheckBox? = view?.findViewById(R.id.chbxDetached3)

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

        loadCheckedDetached(sharedPreferences)

        val editor = sharedPreferences.edit()

        chkDetached1?.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                editor.putBoolean("detached1", true)
                    .apply()
            }
            else{
                editor.remove("detached1")
                    .apply()
            }
        }

        chkDetached2?.setOnCheckedChangeListener { buttonView, isChecked ->
            if(chkDetached2.isChecked){
                editor.putBoolean("detached2", true)
                    .apply()
            }
            else{
                editor.remove("detached2")
                    .apply()
            }
        }

        chkDetached3?.setOnCheckedChangeListener { buttonView, isChecked ->
            if(chkDetached3.isChecked){
                editor.putBoolean("detached3", true)
                    .apply()
            }
            else{
                editor.remove("detached3")
                    .apply()
            }
        }
    }

    fun setDetachedInfo(detachedId: Int,
                        priceId: Int,
                        addressId: Int,
                        bedroomId: Int,
                        bathroomId: Int,
                        imageId: Int){
        val detachedInfo: Array<String> = resources.getStringArray(detachedId)

        val price: String = detachedInfo[0]
        val priceView: TextView? = view?.findViewById(priceId)
        priceView?.text = price

        val address: String = detachedInfo[1]
        val addressView: TextView? = view?.findViewById(addressId)
        addressView?.text = address

        val bedrooms: String = detachedInfo[2]
        val bedroomsView: TextView? = view?.findViewById(bedroomId)
        bedroomsView?.text = bedrooms

        val bathrooms: String = detachedInfo[3]
        val bathroomsView: TextView? = view?.findViewById(bathroomId)
        bathroomsView?.text = bathrooms

        //retrieving array as a TypedArray for the image resource
        val image: TypedArray = resources.obtainTypedArray(detachedId)
        val imageView: ImageView? = view?.findViewById(imageId)
        imageView?.setImageResource(image.getResourceId(4,0))
    }

    fun loadCheckedDetached(sharedPreferences : SharedPreferences){
        if(sharedPreferences.contains("detached1")){ view?.findViewById<CheckBox>(R.id.chbxDetached1)?.isChecked = true }
        if(sharedPreferences.contains("detached2")){ view?.findViewById<CheckBox>(R.id.chbxDetached2)?.isChecked = true }
        if(sharedPreferences.contains("detached3")){ view?.findViewById<CheckBox>(R.id.chbxDetached3)?.isChecked = true }
    }
}
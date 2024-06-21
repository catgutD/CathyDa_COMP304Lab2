package com.example.cathyda_comp304lab2

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private var listingsList: List<String>, val context: Context) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>(){
        var radioButton: RadioButton? = null

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val listingPriceTextView: TextView = view.findViewById(R.id.txtPrice)
            val listingAddressTextView: TextView = view.findViewById(R.id.txtAddress)
            val listingBedroomsTextView: TextView = view.findViewById(R.id.txtBedrooms)
            val listingBathroomsTextView: TextView = view.findViewById(R.id.txtBathrooms)
            val listingImageView: ImageView = view.findViewById(R.id.imgListing)
            val listingRadioButton: RadioButton = view.findViewById(R.id.radioListing)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.listing, parent, false)
            return ViewHolder(itemView)
        }

        @SuppressLint("ResourceType", "Recycle")
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val listing = listingsList[position]

            val listingId: Int = context.resources.getIdentifier(listing, "array", context.packageName)

            val listingInfo: Array<String> = context.resources.getStringArray(listingId)

            holder.listingPriceTextView.text = listingInfo[0]
            holder.listingAddressTextView.text = listingInfo[1]
            holder.listingBedroomsTextView.text = listingInfo[2]
            holder.listingBathroomsTextView.text = listingInfo[3]

            //retrieving array as a TypedArray for the image resource
            val image: TypedArray = context.resources.obtainTypedArray(listingId)
            holder.listingImageView.setImageResource(image.getResourceId(4,0))

            holder.listingRadioButton.setOnClickListener{
                if(radioButton != null){
                    radioButton?.isChecked = false
                }
                holder.listingRadioButton.isChecked = true
                radioButton = holder.listingRadioButton
            }

        }

        override fun getItemCount(): Int {
            return listingsList.size
        }

    }
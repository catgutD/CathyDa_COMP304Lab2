package com.example.cathyda_comp304lab2

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private var listingsList: List<String>, val context: Context) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>(){
        class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            var listingPriceTextView: TextView = view.findViewById(R.id.txtPrice)
            var listingAddressTextView: TextView = view.findViewById(R.id.txtAddress)
            var listingBedroomsTextView: TextView = view.findViewById(R.id.txtBedrooms)
            var listingBathroomsTextView: TextView = view.findViewById(R.id.txtBathrooms)
            var listingImageView: ImageView = view.findViewById(R.id.imgListing)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.listing, parent, false)
            return MyViewHolder(itemView)
        }
        @SuppressLint("ResourceType")
        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
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
        }
        override fun getItemCount(): Int {
            return listingsList.size
        }
    }
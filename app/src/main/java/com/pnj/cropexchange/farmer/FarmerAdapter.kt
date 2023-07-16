package com.pnj.cropexchange.farmer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pnj.cropexchange.R
import com.pnj.cropexchange.farmer.Farmer

class FarmerAdapter(private val farmers: List<Farmer>) :
    RecyclerView.Adapter<FarmerAdapter.FarmerViewHolder>() {

    inner class FarmerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.textViewFarmerName)
        val locationTextView: TextView = itemView.findViewById(R.id.textViewLocation)
        val productTextView: TextView = itemView.findViewById(R.id.textViewProduct)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FarmerViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.farmer_item, parent, false)
        return FarmerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FarmerViewHolder, position: Int) {
        val currentFarmer = farmers[position]
        holder.nameTextView.text = currentFarmer.name
        holder.locationTextView.text = currentFarmer.location
        holder.productTextView.text = currentFarmer.product
    }

    override fun getItemCount(): Int {
        return farmers.size
    }
}

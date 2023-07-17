package com.pnj.cropexchange.product

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pnj.cropexchange.R
import com.pnj.cropexchange.product.Product

class ProductAdapter(private val productlist: ArrayList<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){
    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nama: TextView = itemView.findViewById(R.id.TxtAddNama)
        val berat
    }


}
package com.tremoloo.offer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tremoloo.R

class OffersAdapter(private val data: ArrayList<OfferItem>? = null) :
    RecyclerView.Adapter<OffersAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.offer_item_view, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = data!![position]

        holder.discountPerTextView.text = "${item.discount} OFF"
        holder.offerImageView.setImageResource(item.image)
        holder.sellerTextView.text = item.seller
        holder.offerPriceTextView.text = item.price.toString()
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val offerImageView: ImageView = view.findViewById(R.id.offerImageView)
        val sellerTextView: TextView = view.findViewById(R.id.sellerTextView)
        val offerPriceTextView: TextView = view.findViewById(R.id.offerPriceTextView)
        val discountPerTextView: TextView = view.findViewById(R.id.discountPerTextView)
    }
}
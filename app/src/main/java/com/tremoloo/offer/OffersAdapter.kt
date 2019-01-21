package com.tremoloo.offer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tremoloo.R

class OffersAdapter(private val data: ArrayList<OfferItem>? = null) :
    RecyclerView.Adapter<OffersAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.target_item_view, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

//        val item = data!![position]
//        val percentage = (item.savedAmount / item.price) * 100
//        holder.targetImageView.setImageResource(item.image)
//        holder.targetNameTextView.text = item.name
//        holder.targetPriceTextView.text = item.price.toString()
//        holder.targetProgress.progress = percentage.toInt()
//        holder.targetPercentageTextView.text = percentage.toString()
//        holder.savedAmountTextView.text = item.savedAmount.toString()

    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val targetImageView: ImageView = view.findViewById(R.id.targetImageView)
        val targetNameTextView: TextView = view.findViewById(R.id.targetNameTextView)
        val targetPriceTextView: TextView = view.findViewById(R.id.targetPriceTextView)
        val targetProgress: ProgressBar = view.findViewById(R.id.targetProgress)
        val targetPercentageTextView: TextView = view.findViewById(R.id.targetPersantageTextView)
        val savedAmountTextView: TextView = view.findViewById(R.id.savedAmountTextView)
    }
}
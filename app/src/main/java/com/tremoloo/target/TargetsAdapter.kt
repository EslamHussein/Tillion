package com.tremoloo.target

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tremoloo.R

class TargetsAdapter(private val context: Context, private val data: ArrayList<TargetItem>? = null) :
    RecyclerView.Adapter<TargetsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(context)
            .inflate(R.layout.target_item_view, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = data!![position]
        val percentage = ((item.savedAmount / item.price) * 100).toInt()
        holder.targetImageView.setImageResource(item.image)
        holder.targetNameTextView.text = item.name
        holder.savedPeresantageTextView.text = item.price.toString()
        holder.targetProgress.progress = percentage
        holder.remainingTextView.text = (item.price - item.savedAmount).toString()
        holder.totalPriceTextView.text = item.price.toString()

        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context, TargetDetailsActivity::class.java).apply {
                putExtra("target", item)
            })
        }

    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val targetImageView: ImageView = view.findViewById(R.id.targetImageView)
        val targetNameTextView: TextView = view.findViewById(R.id.targetNameTextView)
        val savedPeresantageTextView: TextView = view.findViewById(R.id.savedPeresantageTextView)
        val targetProgress: ProgressBar = view.findViewById(R.id.targetProgress)
        val remainingTextView: TextView = view.findViewById(R.id.remainingTextView)
        val totalPriceTextView: TextView = view.findViewById(R.id.totalPriceTextView)
    }
}
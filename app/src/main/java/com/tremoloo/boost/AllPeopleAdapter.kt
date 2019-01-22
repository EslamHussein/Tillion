package com.tremoloo.boost

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tremoloo.R


class BoostItem(val image: Int, val name: String, val number: String)
class AllPeopleAdapter(
    private val type: String,
    private val context: Context,
    private val data: ArrayList<BoostItem>? = null, val action: () -> Unit
) :
    RecyclerView.Adapter<AllPeopleAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(context)
            .inflate(R.layout.boost_item_view, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = data!![position]
        holder.boostImageView.setImageResource(item.image)
        holder.boostNameTextView.text = item.name
        holder.boostMobileNumberTextView.text = item.number

        holder.boostActionButton.text = type
        holder.boostActionButton.setOnClickListener {
            action()
        }

    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val boostImageView: ImageView = view.findViewById(R.id.boostImageView)
        val boostNameTextView: TextView = view.findViewById(R.id.boostNameTextView)
        val boostMobileNumberTextView: TextView = view.findViewById(R.id.boostMobileNumberTextView)
        val boostActionButton: Button = view.findViewById(R.id.boostActionButton)
    }
}
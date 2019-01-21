package com.tremoloo.target

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.tremoloo.R
import kotlinx.android.synthetic.main.activity_targed_details.*

class TargetDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_targed_details)
        setSupportActionBar(targetDetailsToolbar)


        val data = intent.getParcelableExtra<TargetItem>("target")
        title = data.name



        targetImageView.setImageResource(data.image)
        val percentage = ((data.savedAmount / data.price) * 100).toInt()

        targetNameTextView.text = data.name
        savedPeresantageTextView.text = percentage.toString()

        targetProgress.progress = percentage
        remainingTextView.text = (data.price - data.savedAmount).toString()
        targetPriceTextView.text = data.price.toString()
        remainingPersantageTextView.text = "${100 - percentage} to go!"
        offersRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@TargetDetailsActivity)
//            adapter = TargetsAdapter(data)
        }

    }
}

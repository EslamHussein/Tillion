package com.tremoloo.target

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.tremoloo.R
import com.tremoloo.offer.OfferItem
import com.tremoloo.offer.OffersAdapter
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
        savedPeresantageTextView.text = "$percentage %"

        targetProgress.progress = percentage
        remainingTextView.text = (data.price - data.savedAmount).toString()
        targetPriceTextView.text = data.price.toString()
        remainingPersantageTextView.text = "${100 - percentage} to go!"

        val offers = ArrayList<OfferItem>()
        repeat(5){

            offers.add(OfferItem(R.drawable.mini_cooper_1,"Ghabour Auto",1000000F,15F))
            offers.add(OfferItem(R.drawable.mini_cooper_2,"El-Tarek",1120000F,0F))


        }

        offersRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@TargetDetailsActivity)
            adapter = OffersAdapter(offers)
        }

    }
}

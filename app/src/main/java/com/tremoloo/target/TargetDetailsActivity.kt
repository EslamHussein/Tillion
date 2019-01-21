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

        offersRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@TargetDetailsActivity)
//            adapter = TargetsAdapter(data)
        }

    }
}

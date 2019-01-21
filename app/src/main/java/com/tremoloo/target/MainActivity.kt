package com.tremoloo.target

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.tremoloo.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_empty_targets.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(mainToolbar)

        val data = ArrayList<TargetItem>()
        repeat(10) {
            data.add(TargetItem("mini copper", R.mipmap.ic_launcher_round, 2000F, 300F))
        }

        setContentView(R.layout.activity_main)
        targedsRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = TargetsAdapter(data)
        }
        targedsRecyclerView.visibility = View.GONE
        addTargetButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, AddTargetActivity::class.java))
        }
    }
}

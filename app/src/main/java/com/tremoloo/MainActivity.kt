package com.tremoloo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.include_empty_targets.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addTargetButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, AddTargetActivity::class.java))
        }
    }
}

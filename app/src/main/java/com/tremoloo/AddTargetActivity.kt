package com.tremoloo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_target.*


class AddTargetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_target)
        setSupportActionBar(addTargetToolbar)

        categoriesRadioGroup.setOnPositionChangedListener { button, currentPosition, lastPosition ->
            Toast.makeText(this@AddTargetActivity, "Position Changed! Position: $currentPosition", Toast.LENGTH_SHORT)
                .show()
        }


        addTargetActionButton.setOnClickListener {
            finish()
        }

    }
}

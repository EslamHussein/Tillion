package com.tremoloo.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tremoloo.MainActivity
import com.tremoloo.R
import kotlinx.android.synthetic.main.activity_set_salary.*

class SetSalaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_salary)
        saveSalaryButton.setOnClickListener {
            startActivity(Intent(this@SetSalaryActivity, MainActivity::class.java))
            finish()
        }
    }
}

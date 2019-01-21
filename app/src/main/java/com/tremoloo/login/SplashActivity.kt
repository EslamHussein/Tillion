package com.tremoloo.login

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.tremoloo.MainActivity
import com.tremoloo.R

private const val SPLASH_TIME_OUT = 3000L

class SplashActivity : AppCompatActivity() {

    private val handler: Handler = Handler()

    private val runnable = {
        val i = Intent(this, LoginActivity::class.java)
        startActivity(i)
        finish()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, SPLASH_TIME_OUT)

    }
    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }

}

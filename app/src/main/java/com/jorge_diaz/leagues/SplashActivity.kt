package com.jorge_diaz.leagues

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jorge_diaz.leagues.utils.TimeUtils.Companion.TWO_SECONDS_IN_MILLIS

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(TWO_SECONDS_IN_MILLIS.toLong())
        startMainActivity()
    }

    private fun startMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
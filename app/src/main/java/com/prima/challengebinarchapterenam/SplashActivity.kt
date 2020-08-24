package com.prima.challengebinarchapterenam

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_splash.*


class SplashActivity : AppCompatActivity() {
    private val splashTimeOut: Long = 3000 // 1 sec
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val username = "guntingbatukertas123"
        val password = "abcabc123"
        val sharedPreferences = getSharedPreferences("MySF", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("username", username)
        editor.putString("password", password)

        editor.apply()


        Glide.with(this)
            .load("https://images.vexels.com/media/users/3/153149/isolated/preview/1dbe90ba2f24289a1668a0dbc8150e2e-gamepad-colored-stroke-icon-by-vexels.png")
            .into(ivMain)


        var mediaPlayer: MediaPlayer? = MediaPlayer.create(this, R.raw.music_loop_1)
        mediaPlayer?.start() // playing raw mp3 file


        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            val intent = Intent(this, LandingActivity::class.java)
            startActivity(intent)

            // close this activity
        }, splashTimeOut)
    }
}
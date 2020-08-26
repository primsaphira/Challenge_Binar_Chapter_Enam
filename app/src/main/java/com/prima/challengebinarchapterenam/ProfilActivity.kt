package com.prima.challengebinarchapterenam

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import com.prima.challengebinarchapterenam.room.MemoDatabase
import kotlinx.android.synthetic.main.activity_profil.*

class ProfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        val sharedPreferences = getSharedPreferences("MySF", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val usernamePlayer = sharedPreferences.getString("username", "No username")
        val emailPlayer = sharedPreferences.getString("email", "No email")

        var db: MemoDatabase? = MemoDatabase.getInstance(this)

        etEmail.setText(emailPlayer)
        etUsername.setText(usernamePlayer)

        //etEmail.addTextChangedListener(object : TextWatcher)

    }
}
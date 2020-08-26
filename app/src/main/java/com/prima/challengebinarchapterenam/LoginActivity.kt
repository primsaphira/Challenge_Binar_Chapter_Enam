package com.prima.challengebinarchapterenam

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sharedPreferences = getSharedPreferences("MySF", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val contains = sharedPreferences.contains("username")
        if(!contains) {
            editor.putString("username","binarian")
            editor.putString("password","binar123")
            editor.putString("email", "binarian@binar.co.id")
            editor.apply()
        }

        btnLogin.setOnClickListener {
            val sharedPreferences = getSharedPreferences("MySF", Context.MODE_PRIVATE)
            val usernamePlayer = sharedPreferences.getString("username", "No username")
            val passwordPlayer = sharedPreferences.getString("password", "No password")

            if (etUsername.text.toString() == usernamePlayer && etPassword.text.toString() == passwordPlayer) {

                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
                finish()

            } else {
                //gagal login
                Toast.makeText(this, "Username / Password Salah", Toast.LENGTH_LONG).show()
            }
        }
    }
}

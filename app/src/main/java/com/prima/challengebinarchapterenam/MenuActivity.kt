package com.prima.challengebinarchapterenam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        //menerima data nama dari intent di kelas third fragment

        val namaUserDariIntent = intent.getStringExtra("nama")

        //set ke textView di xml layout MenuActivity

        tvNamaUser.text = namaUserDariIntent
        tvNama.text = namaUserDariIntent

        ivProfile.setOnClickListener {

        }

        ivPlayMultiplayer.setOnClickListener {
            val intent = Intent(this,GamePlayerActivity::class.java)
            startActivity(intent)
        }

        ivPlayComputer.setOnClickListener {
            val intent = Intent(this,GameComputerActivity::class.java)
            startActivity(intent)
        }
    }
}
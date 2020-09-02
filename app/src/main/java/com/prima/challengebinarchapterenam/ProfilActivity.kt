package com.prima.challengebinarchapterenam

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.recyclerview.widget.LinearLayoutManager
import com.prima.challengebinarchapterenam.dialog.AddMemo
import com.prima.challengebinarchapterenam.dialog.MemoAdapter
import com.prima.challengebinarchapterenam.dialog.UpdateMemo
import com.prima.challengebinarchapterenam.room.Memo
import com.prima.challengebinarchapterenam.room.MemoDatabase
import kotlinx.android.synthetic.main.activity_profil.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProfilActivity : AppCompatActivity() {
    private lateinit var db: MemoDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        val sharedPreferences = getSharedPreferences("MySF", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val usernamePlayer = sharedPreferences.getString("username", "No username")
        val emailPlayer = sharedPreferences.getString("email", "No email")

        MemoDatabase.getInstance(this)?.let {
            db = it
        }

        etEmail.setText(emailPlayer)
        etUsername.setText(usernamePlayer)

        etEmail.addTextChangedListener(object : TextWatcher {
            var emailChange = ""


            override fun afterTextChanged(p0: Editable?) {
                editor.putString("email", emailChange)
                editor.apply()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                emailChange = etEmail.text.toString()
            }

        })

        etUsername.addTextChangedListener(object : TextWatcher {
            var usernameChange = ""
            override fun afterTextChanged(p0: Editable?) {
                editor.putString("username", usernameChange)
                editor.apply()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                usernameChange = etUsername.text.toString()
            }


        })

        btnAdd.setOnClickListener{
            AddMemo().show(supportFragmentManager,"Add Memo Dialog")
        }

    }
    fun fetchData() {
        GlobalScope.launch {
            val listMemo = db.memoDAO().read()
            runOnUiThread {
                rvContainer.layoutManager = LinearLayoutManager(this@ProfilActivity, LinearLayoutManager.VERTICAL, false)
                rvContainer.adapter = MemoAdapter(listMemo)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        fetchData()
    }
    fun showEditDialog(memo: Memo) {
        UpdateMemo.setDataMemo(memo).show(supportFragmentManager,"Update Memo")

    }
}
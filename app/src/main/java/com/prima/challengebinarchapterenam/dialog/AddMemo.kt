package com.prima.challengebinarchapterenam.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.prima.challengebinarchapterenam.ProfilActivity
import com.prima.challengebinarchapterenam.R
import com.prima.challengebinarchapterenam.room.Memo
import com.prima.challengebinarchapterenam.room.MemoDatabase
import kotlinx.android.synthetic.main.add_memo.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddMemo : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_memo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnCancel.setOnClickListener {
            dismiss()
        }
        btnSave.setOnClickListener {
            var db: MemoDatabase? = MemoDatabase.getInstance(activity as ProfilActivity)
            val memo = Memo(null, etIsiTanggal.text.toString(), etIsiMemo.text.toString())

            GlobalScope.launch {
                val savedData = db?.memoDAO()?.create(memo)
                (activity as ProfilActivity).runOnUiThread {
                    if (savedData != null) {
                        if (savedData > 0) {
                            Toast.makeText(view.context,"Data Disimpan",Toast.LENGTH_LONG)
                            (activity as ProfilActivity).fetchData()
                            dismiss()
                        }else{
                            Toast.makeText(view.context,"Data Gagal Disimpan",Toast.LENGTH_LONG)
                        }
                    }
                }
            }
        }
    }
}

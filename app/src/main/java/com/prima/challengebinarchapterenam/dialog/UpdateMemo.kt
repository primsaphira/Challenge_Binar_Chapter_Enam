package com.prima.challengebinarchapterenam.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.prima.challengebinarchapterenam.ProfilActivity
import com.prima.challengebinarchapterenam.R
import com.prima.challengebinarchapterenam.room.Memo
import com.prima.challengebinarchapterenam.room.MemoDatabase
import kotlinx.android.synthetic.main.edit_memo.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UpdateMemo : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.edit_memo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnCancel.setOnClickListener {
            dismiss()
        }
        btnUpdate.setOnClickListener {
            var db: MemoDatabase? = MemoDatabase.getInstance(activity as ProfilActivity)
            val memo = Memo(null, etIsiTanggal.text.toString(), etIsiMemo.text.toString())

            GlobalScope.launch { db?.memoDAO()?.update(memo) }
        }
        btnHapus.setOnClickListener {
            var db: MemoDatabase? = MemoDatabase.getInstance(activity as ProfilActivity)
            val memo = Memo(null, etIsiTanggal.text.toString(), etIsiMemo.text.toString())

            GlobalScope.launch { db?.memoDAO()?.delete(memo) }
        }
    }
}

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
import kotlinx.android.synthetic.main.edit_memo.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UpdateMemo : DialogFragment() {

    companion object{
        lateinit var memo: Memo
        fun setDataMemo(dataMemo: Memo) : UpdateMemo{
            memo = dataMemo
            return UpdateMemo()
        }
    }

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
        etIsiTanggal.setText(memo.tanggal)
        etIsiMemo.setText(memo.isimemo)

        btnCancel.setOnClickListener {
            dismiss()
        }
        btnUpdate.setOnClickListener {
            var db: MemoDatabase? = MemoDatabase.getInstance(activity as ProfilActivity)
            //val memo = Memo(null, etIsiTanggal.text.toString(), etIsiMemo.text.toString())
            memo.apply {
                tanggal = etIsiTanggal.text.toString()
                isimemo = etIsiMemo.text.toString()
            }

            GlobalScope.launch {
                val dataUpdated = db?.memoDAO()?.update(memo)
                (activity as ProfilActivity).runOnUiThread {
                    if (dataUpdated != null) {
                        if (dataUpdated > 0) {
                            Toast.makeText(view.context,"Data Diubah", Toast.LENGTH_LONG)
                            (activity as ProfilActivity).fetchData()
                            dismiss()
                        }else{
                            Toast.makeText(view.context,"Data Gagal Diubah", Toast.LENGTH_LONG)
                        }
                    }
                }
            }
        }
        btnHapus.setOnClickListener {
            var db: MemoDatabase? = MemoDatabase.getInstance(activity as ProfilActivity)
            //val memo = Memo(null, etIsiTanggal.text.toString(), etIsiMemo.text.toString())

            GlobalScope.launch {
                val dataDeleted = db?.memoDAO()?.delete(memo)
                (activity as ProfilActivity).runOnUiThread {
                    if (dataDeleted != null) {
                        if (dataDeleted > 0) {
                            Toast.makeText(view.context,"Data Dihapus", Toast.LENGTH_LONG)
                            (activity as ProfilActivity).fetchData()
                            dismiss()
                        }else{
                            Toast.makeText(view.context,"Data Gagal Dihapus", Toast.LENGTH_LONG)
                        }
                    }
                }
            }
        }
    }
}

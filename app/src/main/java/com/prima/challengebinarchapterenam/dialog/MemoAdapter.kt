package com.prima.challengebinarchapterenam.dialog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.prima.challengebinarchapterenam.R
import com.prima.challengebinarchapterenam.room.Memo
import kotlinx.android.synthetic.main.item_memo.view.*

class MemoAdapter (val listMemo : List<Memo>) : RecyclerView.Adapter<MemoAdapter.ViewHolder>() {

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_memo, parent, false)
            return ViewHolder(itemView)
        }

        override fun getItemCount(): Int {
            return listMemo.size

        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tvIsiTanggal.setText(listMemo[position].tanggal)
        holder.itemView.tvIsiMemo.setText(listMemo[position].isimemo)

        holder.itemView.setOnClickListener {

        }
    }

}
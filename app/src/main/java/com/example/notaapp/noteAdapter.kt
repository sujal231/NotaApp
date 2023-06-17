package com.example.notaapp

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.notaapp.Enitiy.noteenitiy
import com.example.notaapp.databinding.ItemBinding

class noteAdapter(getnote: List<noteenitiy>) : RecyclerView.Adapter<noteAdapter.noteHoler>() {

    var getnote = getnote

    class noteHoler(itemView: ItemBinding) : ViewHolder(itemView.root) {

        var binding = itemView


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): noteHoler {

        var binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return noteHoler(binding)

    }

    override fun getItemCount(): Int {

        return getnote.size

    }

    override fun onBindViewHolder(holder: noteHoler, position: Int) {

        holder.binding.apply {
            txttitle.isSelected = true
            getnote.get(position).apply {
                txttext.text = title
                txttitle.text = text
                txttime.text = date

//                txttext.setOnLongClickListener(object : OnLongClickListener
//                {
//                    override fun onLongClick(p0: View?): Boolean {
//
//                    }
//
//                })

            }
        }

    }

    fun updata(getnote: List<noteenitiy>) {
        this.getnote = getnote
        notifyDataSetChanged()

    }
}
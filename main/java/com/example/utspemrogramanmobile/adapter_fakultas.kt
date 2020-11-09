package com.example.utspemrogramanmobile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_fakultas.view.*

class adapter_fakultas (val itemFac: List<data_fakultas>, val clickListener: (data_fakultas) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_fakultas, parent, false)
        return PartViewHolder(view)
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PartViewHolder).bind(itemFac[position], clickListener)
    }
    override fun getItemCount() = itemFac.size
    class PartViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(data: data_fakultas, clickListener: (data_fakultas) -> Unit){
            itemView.list_fak.text = data.namaFakultas
            itemView.image_fak.setImageResource(data.imgFak)
            itemView.image_fak.contentDescription = data.namaFakultas
            itemView.setOnClickListener { clickListener(data) }
        }
    }
}


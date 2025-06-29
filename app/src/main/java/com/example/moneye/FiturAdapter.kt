package com.example.moneye

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FiturAdapter(private val fiturList: List<Fitur>) :
    RecyclerView.Adapter<FiturAdapter.FiturViewHolder>() {

    class FiturViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nama: TextView = itemView.findViewById(R.id.tvFiturTitle)
        val tipe: TextView = itemView.findViewById(R.id.tvTipeData)
        val bentuk: TextView = itemView.findViewById(R.id.tvBentukData)
        val deskripsi: TextView = itemView.findViewById(R.id.tvFiturDeskripsi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FiturViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_fitur, parent, false)
        return FiturViewHolder(view)
    }

    override fun onBindViewHolder(holder: FiturViewHolder, position: Int) {
        val fitur = fiturList[position]
        holder.nama.text = fitur.nama
        holder.tipe.text = "Tipe Data: ${fitur.tipe}"
        holder.bentuk.text = "Bentuk Nilai fitur: ${fitur.bentuk}"
        holder.deskripsi.text = fitur.deskripsi
    }

    override fun getItemCount(): Int = fiturList.size
}

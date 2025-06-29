package com.example.moneye

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ModelAdapter(private val sections: List<ModelSection>) :
    RecyclerView.Adapter<ModelAdapter.SectionViewHolder>() {

    class SectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tvSectionTitle)
        val subtitle: TextView = itemView.findViewById(R.id.tvSectionSubtitle)
        val description: TextView = itemView.findViewById(R.id.tvSectionDesc)
        val image: ImageView = itemView.findViewById(R.id.ivSectionImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_model_section, parent, false)
        return SectionViewHolder(view)
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        val item = sections[position]
        holder.title.text = item.title

        if (!item.subtitle.isNullOrEmpty()) {
            holder.subtitle.text = item.subtitle
            holder.subtitle.visibility = View.VISIBLE
        } else {
            holder.subtitle.visibility = View.GONE
        }

        holder.description.text = item.description

        if (item.imageResId != null) {
            holder.image.setImageResource(item.imageResId)
            holder.image.visibility = View.VISIBLE
        } else {
            holder.image.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int = sections.size
}

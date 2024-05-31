package com.example.submissiondicoding

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListFilmAdapter(private val listFilm: ArrayList<Film>) : RecyclerView.Adapter<ListFilmAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPoster: ImageView = itemView.findViewById(R.id.img_item_poster)
        val tvTitle: TextView = itemView.findViewById(R.id.tv_item_title)
        val tvRate: TextView = itemView.findViewById(R.id.tv_item_rate)
        val tvSinopsis: TextView = itemView.findViewById(R.id.tv_item_sinopsis)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_film, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listFilm.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, rate, poster, sinopsis) = listFilm[position]
        holder.imgPoster.setImageResource(poster)
        holder.tvTitle.text = title
        holder.tvRate.text = rate
        holder.tvSinopsis.text = sinopsis
    }
}
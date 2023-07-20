package com.example.poiskfilmoff

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.poiskfilmoff.databinding.FilmItemBinding

class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    private val binding = FilmItemBinding.bind(itemView)

    fun bind(film: Film,listener: FilmListRecyclerAdapter.Listener) = with(binding){
        poster.setImageResource(film.poster)
        title.text=film.title
        description.text=film.description
        itemContainer.setOnClickListener{
            listener.onClick(film)


        }
    }



}
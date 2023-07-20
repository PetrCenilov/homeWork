package com.example.poiskfilmoff

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView




class FilmListRecyclerAdapter(private val listener:Listener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = mutableListOf<Film>()

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.film_item,parent,false)
        return FilmViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FilmViewHolder -> {
                holder.bind(items[position],listener)


            }
        }
    }

    fun addItems(list: List<Film>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }



    interface Listener {
        fun onClick(film: Film)
    }

    }




//class FilmViewHolder(item:View): RecyclerView.ViewHolder(item) {
    // private val binding = FilmItemBinding.bind(item)
    //fun bind(film: Film,clickListener: OnItemClickListener) = with(binding) {
    //poster.setImageResource(film.poster)
    //title.text= film.title
    //description.text= film.description
    //itemView.setOnClickListener{
    //clickListener.click(film)

    //}

    //}

    //}

    // override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
    // val view = LayoutInflater.from(parent.context).inflate(R.layout.film_item,parent,false)
    // return FilmViewHolder(view)
//}

    //override fun getItemCount(): Int {
        //return items.size
    //}


    //override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
       // holder.bind(items[position], clickListener)
    //}

    //fun addItems(list: List<Film>) {
        //items.clear()
        //items.addAll(list)

    //}
    //interface OnItemClickListener {
        //fun click(film: Film)
    //}

//}
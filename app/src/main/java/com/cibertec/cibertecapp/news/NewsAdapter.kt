package com.cibertec.cibertecapp.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter: RecyclerView.Adapter<NewsViewHolder>() {

    private var newList = emptyList<New>()

    fun setNews(news: List<New>) {
        this.newList = news
        this.notifyDataSetChanged()
    }

    // Crear - Conectar con el ViewHolder
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NewsViewHolder(inflater, parent)
    }

    // Asignar datos al ViewHolder
    override fun onBindViewHolder(
        holder: NewsViewHolder,
        position: Int
    ) {
        val new: New = newList[position]
        holder.bind(new)
    }

    // Indicar el numero de elementos que tendra la lista
    override fun getItemCount(): Int {
       return newList.size
    }


}
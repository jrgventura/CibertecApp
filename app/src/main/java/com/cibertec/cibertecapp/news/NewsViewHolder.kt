package com.cibertec.cibertecapp.news

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.cibertecapp.R


class NewsViewHolder(inflater: LayoutInflater,
    parent: ViewGroup):
    RecyclerView.ViewHolder(
        inflater.inflate(
            R.layout.item_new,
            parent, false)) {


        private var imgPortada: ImageView? = null
        private var textTitulo: TextView? = null
        private var textDescripcion: TextView? = null

    init {
        imgPortada = itemView.findViewById(R.id.imgPortada)
        textTitulo = itemView.findViewById(R.id.textTitulo)
        textDescripcion = itemView.findViewById(R.id.textDescripcion)
    }

    fun bind(noticia: New) {
        imgPortada?.setImageResource(noticia.portada)
        textTitulo?.text = noticia.titulo
        textDescripcion?.text = noticia.decripcion
    }

}
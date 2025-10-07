package com.cibertec.cibertecapp.note

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.cibertecapp.R

class NoteViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_note,
        parent, false)) {

        private var textDate: TextView? = null
    private var textTitle: TextView? = null
    private var textDescription: TextView? = null

    init {
        textDate = itemView.findViewById(R.id.textDate)
        textTitle = itemView.findViewById(R.id.textTitle)
        textDescription = itemView.findViewById(R.id.textDescripcion)
    }
    fun data(note: Note) {
        textDate?.text = note.date
        textTitle?.text = note.title
        textDescription?.text = note.description
    }

}
package com.cibertec.cibertecapp.note

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(val listener: NoteListener): RecyclerView.Adapter<NoteViewHolder>(){

    private var listNote = emptyList<Note>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NoteViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(
        holder: NoteViewHolder,
        position: Int
    ) {
        val note = listNote[position]
        holder.data(note)
        holder.itemView.setOnClickListener {
            listener.onClickListener(note)
        }
    }

    override fun getItemCount(): Int {
        return listNote.size
    }

    fun setNotes(notes: List<Note>) {
        this.listNote = notes
        this.notifyDataSetChanged()
    }

    fun deleteItem(position: Int) {
        notifyItemRemoved(position)
    }

    interface NoteListener {
        fun onClickListener(note: Note)
    }

}
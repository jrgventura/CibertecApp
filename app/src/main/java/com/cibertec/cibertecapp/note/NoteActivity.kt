package com.cibertec.cibertecapp.note

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.cibertecapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class NoteActivity: AppCompatActivity(), NoteAdapter.NoteListener {

    private lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        noteViewModel = ViewModelProvider(this)[NoteViewModel::class]

        val recyclerNotes = findViewById<RecyclerView>(R.id.recyclerNotes)
        val floatingRegister = findViewById<FloatingActionButton>(R.id.floatingRegister)
        floatingRegister.setOnClickListener {
            dialogRegisterNote(null)
        }

        val adapter = NoteAdapter(this)
        recyclerNotes.adapter = adapter
        recyclerNotes.layoutManager = LinearLayoutManager(this)

        noteViewModel.getNotes().observe(this) { notes ->
            if(notes.isNotEmpty()) {
                notes?.let {
                    adapter.setNotes(notes)
                }
            }
        }

    }

    override fun onClickListener(note: Note) {
        dialogRegisterNote(note)
    }


    private fun dialogRegisterNote(note: Note?) {
        val mDialog = LayoutInflater.from(this).inflate(R.layout.dialog_note, null)
        val titleAlertNote = if (note !=null) "Actualizar nota" else "Registrar nota"

        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialog)
            .setTitle(titleAlertNote)

        val mAlertDialog = mBuilder.show()

        val btnCreate = mDialog.findViewById<Button>(R.id.btnCreate)
        var edtTitle = mDialog.findViewById<EditText>(R.id.edtTitleNote)
        val edtDescription = mDialog.findViewById<EditText>(R.id.edtDescriptionNote)

        if (note !=null) {
            edtTitle.setText(note.title)
            edtDescription.setText(note.description)
        }

        btnCreate.setOnClickListener {
            mAlertDialog.dismiss()
            val titleNote = edtTitle.text.toString()
            val descriptionNote = edtDescription.text.toString()
            val dateCurrent = LocalDateTime.now().formatChangeNote()

            if (note != null) {
                note.title = titleNote
                note.description = descriptionNote
                note.date = dateCurrent
                noteViewModel.updateNote(note)
            } else {
                val note = Note(titleNote, descriptionNote, dateCurrent)
                noteViewModel.insertNote(note)
            }




        }

    }

    fun LocalDateTime.formatChangeNote() : String
     = this.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))


}
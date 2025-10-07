package com.cibertec.cibertecapp.note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NoteViewModel (application: Application): AndroidViewModel(application) {

    private val repository = NoteRepository(application)

    fun getNotes(): LiveData<List<Note>> {
        return repository.getNotes()
    }

    fun insertNote(note: Note) {
        viewModelScope.launch {
            repository.insertNote(note)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch {
            repository.updateNote(note)
        }
    }

}
package com.cibertec.cibertecapp.note

import android.app.Application
import androidx.lifecycle.LiveData
import com.cibertec.cibertecapp.database.CibertecDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NoteRepository(application: Application) {

    private val noteDAO = CibertecDatabase.getInstance(application).noteDAO()

    fun getNotes(): LiveData<List<Note>> {
        return noteDAO.getNotes()
    }

    suspend fun insertNote(note: Note) {
        withContext(Dispatchers.IO) {
            noteDAO.insert(note)
        }
    }

    suspend fun updateNote(note: Note) {
        withContext(Dispatchers.IO) {
            noteDAO.update(note)
        }
    }

}
package com.cibertec.cibertecapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.cibertec.cibertecapp.note.Note

@Dao
interface NoteDAO {

    @Insert
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("SELECT * FROM note_table")
    fun getNotes(): LiveData<List<Note>>

}
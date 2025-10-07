package com.cibertec.cibertecapp.note

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note(
    @ColumnInfo(name = "title_note")
    var title: String,
    @ColumnInfo(name = "description_note")
    var description: String,
    @ColumnInfo(name = "date_note")
    var date: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_note")
    var noteID: Int = 0
}
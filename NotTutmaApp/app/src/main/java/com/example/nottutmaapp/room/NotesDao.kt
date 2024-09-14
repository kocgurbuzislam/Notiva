package com.example.nottutmaapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.nottutmaapp.data.entity.Notes

@Dao
interface NotesDao {

    @Query("SELECT * FROM notes")
    suspend fun getNotes(): List<Notes>

    @Insert
    suspend fun saveNotes(notes: Notes)

    @Delete
    suspend fun deleteNotes(notes: Notes)

    @Update
    suspend fun getNotesDetail(notes: Notes)

    @Query("SELECT * FROM notes WHERE notes_title like '%' || :searchWord || '%'")
    suspend fun searchNotes(searchWord: String): List<Notes>

}
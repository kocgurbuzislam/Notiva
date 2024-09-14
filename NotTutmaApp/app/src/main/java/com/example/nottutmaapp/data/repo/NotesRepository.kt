package com.example.nottutmaapp.data.repo

import com.example.nottutmaapp.data.datasource.NotesDataSource
import com.example.nottutmaapp.data.entity.Notes

class NotesRepository(var noteds: NotesDataSource) {

    suspend fun addNotes(note_title: String, note_detail: String){
        return noteds.addNotes(note_title, note_detail)
    }

    suspend fun updateNotes(note_id: Int, note_title: String, note_detail: String){
        return noteds.updateNote(note_id, note_title, note_detail)
    }

    suspend fun getNotes(): List<Notes>{
        return noteds.getNotes()
    }

    suspend fun deleteNotes(note_id: Int){
        return noteds.deleteNotes(note_id)
    }
    suspend fun searchNotes(searchWord: String): List<Notes>{
        return noteds.searchNotes(searchWord)
    }


}
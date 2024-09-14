package com.example.nottutmaapp.data.datasource

import com.example.nottutmaapp.data.entity.Notes
import com.example.nottutmaapp.room.NotesDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NotesDataSource(var notesDao: NotesDao) {


    suspend fun getNotes(): List<Notes> =
        withContext(Dispatchers.IO){
        return@withContext notesDao.getNotes()
    }

    suspend fun addNotes(note_title: String, note_detail: String){
        val note = Notes(0, note_title, note_detail)
        return notesDao.saveNotes(note)
    }

    suspend fun deleteNotes(note_id: Int){
        val note = Notes(note_id, "", "")
        return notesDao.deleteNotes(note)
    }

    suspend fun updateNote(note_id: Int, note_title: String, note_detail: String){
        val note = Notes(note_id, note_title, note_detail)
        return notesDao.getNotesDetail(note)
    }

    suspend fun searchNotes(searchWord: String): List<Notes> =
        withContext(Dispatchers.IO){
            return@withContext notesDao.searchNotes(searchWord)

        }




}